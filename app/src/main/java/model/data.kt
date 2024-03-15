package model

import com.google.gson.annotations.SerializedName

data class Donut(

    var batters: Batters,
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("ppu")
    var ppu: Double,
    @SerializedName("topping")
    var topping: List<Topping>,
    @SerializedName("type")
    var type: String
)

data class Batters(
    @SerializedName("better")
    var batter: List<Batter>
)

data class Topping(
    @SerializedName("id")
    var id: String,
    @SerializedName("type")
    var type: String
)

data class Batter(
    @SerializedName("id")
    var id: String,
    @SerializedName("type")
    var type: String
)

