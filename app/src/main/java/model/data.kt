package model

class data {
    private var id: String? = null
    private var type: String? = null
    private var name: String? = null
    private var ppu: String? = null
    private var batters: String? = null
    private var topping: String? = null

    fun getId(): String? {
        return id
    }

    fun getType(): String? {
        return type
    }

    fun getName(): String? {
        return name
    }

    fun getPpu(): String? {
        return ppu
    }

    fun getBatters(): String?{
        return batters
    }

    fun getTopping():String?{
        return topping
    }
}