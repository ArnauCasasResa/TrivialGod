sealed class Routes(val route: String) {
    object SplashScreen:Routes("splash_screen")
    object MenuScreen:Routes("menu_screen")
    object GameScreen:Routes("game_screen/{dificultad}"){
        fun createRoute(dificultad:String) = "game_screen/$dificultad"
    }
    object EndScreen:Routes("end_screen/{win}/{tries}"){
        fun createRoute(win:Boolean,tries:Int) = "end_screen/$win/$tries"
    }


}

