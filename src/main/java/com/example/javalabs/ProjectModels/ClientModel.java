package com.example.javalabs.ProjectModels;

import com.example.javalabs.ConnectionSupport.Connection;
import com.example.javalabs.Controllers.Controller;
import com.example.javalabs.ConnectionSupport.Message;
import com.example.javalabs.ConnectionSupport.MessageType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.net.Socket;

public class ClientModel {
    private Connection connection;
    private ClientModel user;
    private boolean isConnect = false;

    public boolean IsConnect(){
        return isConnect;
    }

    public void SetConnect(boolean connect){
        isConnect = connect;
    }
    private Controller mainController;
    private String username;
    public ClientModel(Controller controller){
        user = this;
        mainController = controller;

        ConnectToServer();
        UserThread listener = new UserThread(connection, controller);
        listener.start();
    }

    void ConnectToServer(){
        if(!isConnect){
            while(true){
                try{
                    Socket socket = new Socket("localhost",9999);
                    connection = new Connection(socket);
                    isConnect = true;
                    break;
                }catch (Exception e){

                }
            }
        }
    }

    public void StopConnection(){
        isConnect = false;
    }

    void userTabSend(String inData) throws IOException {
        connection.Send(new Message(inData, MessageType.TAB_USER_REQUEST));
    }

    void gameStatsTabSend(String inData) throws IOException {
        connection.Send(new Message(inData, MessageType.TAB_GAMESCORE_REQUEST));
    }

    void genreTabSend() throws IOException {
        connection.Send(new Message(MessageType.TAB_GENRE_REQUEST));
    }


    class UserThread extends Thread{
        private Connection connection;
        Controller appController;
        UserThread(Connection connection, Controller appController){
            System.out.println("User Thread Created!");

            this.appController = appController;
            this.connection = connection;
        }

        @Override
        public void run(){
            while(user.IsConnect()){
                if(user.IsConnect()){
                    System.out.println("Receiving messages...");
                    ReceiveMessageFromServer();
                }
            }
        }

        protected void ReceiveMessageFromServer() {
            while (isConnect) {
                try {
                    Message message = connection.Receive();

                    switch (message.GetMessageType()) {
                        case TAB_USER_RESPONSE -> {
                            System.out.println("Sending request from user tab");

                            appController.setUserTabData(message.GetAccountName(),message.GetIngameName(),message.GetAchievements(),message.GetGameStore());
                            break;
                        }
                        case TAB_GAMESCORE_RESPONSE -> {
                            System.out.println("Sending request from gamestats tab");
                            appController.setGameStatsTabData(message.GetTotalTime(),message.GetSessionTime(),message.GetCurrentScore());
                            break;
                        }
                        case TAB_GENRE_RESPONSE -> {
                            System.out.println("Sending request from genre tab");
                            appController.setGenreTabData(genreParse(message.GetGenreList()), tagParse(message.GetTagList()));
                            break;
                        }
                    }
                } catch (Exception e) {

                }
            }
        }
        ObservableList<String> genreParse(String inData) {
            String[] words = inData.split(" ");
            ObservableList<String> res = FXCollections.observableArrayList(words);
            return res;
        }
        ObservableList<String> tagParse(String inData) {
            String[] words = inData.split(" ");
            ObservableList<String> res = FXCollections.observableArrayList(words);
            return res;
        }
    }
}
