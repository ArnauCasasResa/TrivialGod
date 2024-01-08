sealed class Routes(val route: String) {
    object SplashScreen:Routes("splash_screen")
    object MenuScreen:Routes("menu_screen")
    object GameScreen:Routes("game_screen")
    object EndScreenGood:Routes("end_screen_good")
    object EndScreenBad:Routes("end_screen_bad")
}
