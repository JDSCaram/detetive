package com.jdscaram.suspeito.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.jdscaram.suspeito.R

enum class Card(
    @StringRes val cardName: Int,
    @DrawableRes val color: Int?,
    val type: Type,
) {
    // Characters
    DRIVER(R.string.card_driver, R.color.card_driver, Type.CHARACTER),
    HOUSE_KEEPER(R.string.card_housekeeper, R.color.card_housekeeper, Type.CHARACTER),
    CHEF(R.string.card_chef, R.color.card_chef, Type.CHARACTER),
    BUTLER(R.string.card_butler, R.color.card_butler, Type.CHARACTER),
    WIFE(R.string.card_wife, R.color.card_wife, Type.CHARACTER),
    GARDENER(R.string.card_gardener, R.color.card_gardener, Type.CHARACTER),
    NEIGHBOR(R.string.card_neighbor, R.color.card_neighbor, Type.CHARACTER),

    // Weapons
    GUN(R.string.card_gun, null, Type.WEAPON),
    KNIFE(R.string.card_knife, null, Type.WEAPON),
    SCISSORS(R.string.card_scissors, null, Type.WEAPON),
    SPANNER(R.string.card_spanner, null, Type.WEAPON),
    POISON(R.string.card_poison, null, Type.WEAPON),
    BEDSIDE_LAMP(R.string.card_bedside_lamp, null, Type.WEAPON),
    HAMMER(R.string.card_hammer, null, Type.WEAPON),

    // Places,
    BALCONY(R.string.card_balcony, null, Type.PLACE),
    OFFICE(R.string.card_office, null, Type.PLACE),
    CENTRAL_HALL(R.string.card_hall_central, null, Type.PLACE),
    LIBRARY(R.string.card_library, null, Type.PLACE),
    DINING_ROOM(R.string.card_dining_room, null, Type.PLACE),
    KITCHEN(R.string.card_kitchen, null, Type.PLACE),
    BATH_ROOM(R.string.card_bath_room, null, Type.PLACE),
    SUITE(R.string.card_suite, null, Type.PLACE),
    BED_ROOM(R.string.card_bed_room, null, Type.PLACE),
    STAIRS(R.string.card_stairs, null, Type.PLACE),
}
