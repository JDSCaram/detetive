package com.jdscaram.suspeito.containers

import android.util.Log
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.jdscaram.suspeito.R
import com.jdscaram.suspeito.components.BottomDialog
import com.jdscaram.suspeito.components.card.CardLocationRow
import com.jdscaram.suspeito.components.theme.DetectiveTheme
import com.jdscaram.suspeito.core.ext.func.Callback0
import com.jdscaram.suspeito.core.ext.func.Callback1
import com.jdscaram.suspeito.domain.model.Card
import com.jdscaram.suspeito.domain.model.Location
import com.jdscaram.suspeito.ui.edit.EditViewAction
import com.jdscaram.suspeito.ui.edit.EditViewModel

@Composable
fun EditContainer(editViewModel: EditViewModel) {
    DetectiveTheme {
        val card by editViewModel.card.collectAsState()
        val location by editViewModel.location.collectAsState()
        val description by editViewModel.description.collectAsState()

        EditContent(
            card = card,
            selectedOption = location,
            description = description,
            onLocationSelected = {
                editViewModel.dispatch(EditViewAction.ChangeLocation(it))
            },
            onTextChanged = {
                editViewModel.dispatch(EditViewAction.UpdateObservation(it))
            },
            onFinishEdit = {
                editViewModel.dispatch(EditViewAction.Save(isAutoSave = false))
            }
        )
    }
}

@Composable
fun EditContent(
    card: Card?,
    selectedOption: Location?,
    description: String,
    onLocationSelected: Callback1<Location> = {},
    onTextChanged: Callback1<String> = {},
    onFinishEdit: Callback0 = {},
) {
    if (card == null || selectedOption == null) return

    BottomDialog {
        val cardName = stringResource(id = card.cardName)
        val title = stringResource(
            id = R.string.edit_dialog_title_format,
            formatArgs = arrayOf(cardName)
        )

        Text(
            text = title,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.h6
        )

        Text(
            text = stringResource(id = R.string.edit_dialog_location_title),
            modifier = Modifier.padding(top = 4.dp)
        )

        CardLocationRow(
            selectedOption = selectedOption,
            onClick = onLocationSelected
        )

        Text(
            text = stringResource(id = R.string.edit_dialog_location_observation),
            modifier = Modifier.padding(top = 4.dp)
        )

        TextField(
            value = description,
            onValueChange = {
                Log.d("FAOGUSTAVO", "TextField.onValueChange($it) called")
                onTextChanged(it)
            },
            imeAction = ImeAction.Done,
            onImeActionPerformed = { _, _ -> onFinishEdit() },
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = Color.Transparent
        )
    }
}

@Preview
@Composable
fun PreviewEditContent() {
    DetectiveTheme {
        EditContent(
            card = Card.BALCONY,
            selectedOption = Location.HAND,
            description = "Lorem Ipsum",
        )
    }
}
