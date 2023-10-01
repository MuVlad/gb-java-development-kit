package mu.vlad.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class ChatWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 640;
    private static final int WINDOW_WIDTH = 720;
    private static final int WINDOW_POS_X = 300;
    private static final int WINDOW_POS_Y = 100;
    private static final String WINDOW_NAME = "Чат с сервером";


    JTextArea textOutput = new JTextArea("");
    JLabel label = new JLabel("Введите сообщение серверу: ");
    JTextField textInput = new JTextField();

    JButton sendButton = new JButton("Отправить");

    JPanel grid = new JPanel(new GridLayout(4, 1));

    ChatWindow(String login) {
        //свойства окна
        setTitle(WINDOW_NAME);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);

        textOutput.setEditable(false);
        textOutput.append(readingLogFile());
        grid.add(textOutput);
        grid.add(label);
        grid.add(textInput);
        grid.add(sendButton);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg(login);
            }
        });

        textInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMsg(login);
                }
            }
        });


        add(grid);
        setVisible(true);
    }

    private void sendMsg(String login) {
        String msg = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss/dd.MM")) + " " + login + " : " + textInput.getText() + "\n";
        textOutput.append(msg);
        WriteLogToFile(msg);
        textInput.setText("");
    }

    private static void WriteLogToFile(String msg) {
        try (BufferedWriter writerLog = new BufferedWriter(new FileWriter("log.txt", true))) {
            writerLog.write(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readingLogFile() {
        File fileLog = new File("log.txt");
        if (fileLog.exists()) {
            try (BufferedReader readerLogFile = new BufferedReader(new FileReader(fileLog))) {
                return readerLogFile.lines().collect(Collectors.joining("\n"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "";
    }
}
