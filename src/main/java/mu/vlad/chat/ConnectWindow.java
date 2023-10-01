package mu.vlad.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectWindow extends JFrame {
    static private final int WINDOW_HEIGHT = 640;
    static private final int WINDOW_WIDTH = 720;
    static private final int WINDOW_POS_X = 300;
    static private final int WINDOW_POS_Y = 100;
    static private final String WINDOW_NAME = "Подключение к серверу";

    JTextField loginField = new JTextField("Введите ваш логин: ");
    JTextField passwordField = new JTextField("Введите ваш пароль: ");
    JTextField serverField = new JTextField("Введите адрес сервера и порт для подключения: ");
    JButton connectButton = new JButton("Подключиться");

    JPanel grid = new JPanel(new GridLayout(4,1));

    ConnectWindow(){
        //свойства окна
        setTitle(WINDOW_NAME);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        grid.add(loginField);
        grid.add(passwordField);
        grid.add(serverField);
        grid.add(connectButton);

        add(grid);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String login = loginField.getText().replace("Введите ваш логин: ", "");
                new ChatWindow(login);
            }
        });

        setVisible(true);
    }
}
