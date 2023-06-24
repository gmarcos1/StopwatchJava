import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stop_watch extends JFrame implements ActionListener {
    private JLabel timeLabel;
    private JButton botaoiniciar, botaoparar, botaoresetar;
    private Timer timer;
    private int elapsedTime;

    public Stop_watch() {
        setTitle("Cronometro");
        setSize(600, 300);
        timeLabel = new JLabel("00:00:00", JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        timeLabel.setForeground(Color.red);

        botaoiniciar = new JButton("Iniciar");
        botaoiniciar.addActionListener(this);
        botaoparar = new JButton("Parar");
        botaoparar.addActionListener(this);
       botaoresetar = new JButton("Reset");
        botaoresetar.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(botaoiniciar);
        buttonPanel.add(botaoparar);
        buttonPanel.add(botaoresetar);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(timeLabel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        // Set up the timer
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                elapsedTime += 1000;
                updateTimeLabel();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoiniciar) {
            timer.start();
        } else if (e.getSource() == botaoparar) {
            timer.stop();
        } else if (e.getSource() == botaoresetar) {
            timer.stop();
            elapsedTime = 0;
            updateTimeLabel();
        }
    }

    private void updateTimeLabel() {
        int hours = elapsedTime / 3600000;
        int minutes = (elapsedTime % 3600000) / 60000;
        int seconds = (elapsedTime % 60000) / 1000;
        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        timeLabel.setText(time);
    }

    public static void main(String[] args) {
        Stop_watch frame = new Stop_watch();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setVisible(true);
    }
}