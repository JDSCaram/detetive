package com.jdscaram.suspeito.ui.edit

import com.jdscaram.suspeito.domain.model.Card
import com.jdscaram.suspeito.domain.model.Location

sealed class EditViewAction {
    class Init(val card: Card) : EditViewAction()
    class ChangeLocation(val newLocation: Location) : EditViewAction()
    class UpdateObservation(val text: String) : EditViewAction()
    class Save(val isAutoSave: Boolean) : EditViewAction()
}
