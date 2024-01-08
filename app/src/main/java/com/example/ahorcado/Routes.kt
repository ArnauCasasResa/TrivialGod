sealed class Routes(val route: String) {
    object SplashScreen:Routes("splash_screen")
    object MenuScreen:Routes("menu_screen")
    object GameScreen:Routes("game_screen/{dificultad}"){
        fun createRoute(dificultad:String) = "game_screen/$dificultad"
    }
    object EndScreen:Routes("end_screen/{win}"){
        fun createRoute(win:Boolean) = "end_screen/$win"
    }


}

