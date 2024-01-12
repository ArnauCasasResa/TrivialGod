sealed class Routes(val route: String) {
    object MenuScreen:Routes("menu_screen")
    object GameScreen:Routes("game_screen/{dificultad}"){
        fun createRoute(dificultad:String) = "game_screen/$dificultad"
    }
    object EndScreen:Routes("end_screen/{win}/{tries}/{dificultad}"){
        fun createRoute(win:Boolean,tries:Int,dificultad: String) = "end_screen/$win/$tries/$dificultad"
    }


}

