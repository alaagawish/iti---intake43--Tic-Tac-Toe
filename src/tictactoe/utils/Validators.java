package tictactoe.utils;

class Validators {

    static boolean isValidUsername(String username) {
        return username.length() >= 10;
    }

    static boolean isValidPassword(String password) {
        return password.length() >= 6;
    }

//   static <T>  void setScene(Stage stage) {
//        
//        Parent pane = new <T> (stage);
//        Scene scene = new Scene(pane);
//        stage.setScene(scene);
//    }

}
