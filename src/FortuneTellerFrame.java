import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    ArrayList<String> fortunes = new ArrayList<>();
    Random generator = new Random();

    ArrayList<Integer> repeat  = new ArrayList<>();
    JTextArea textArea = new JTextArea(3,10);
    JScrollPane scrollPane = new JScrollPane(textArea);


    public FortuneTellerFrame() {


        fortunes.add("You will have a great day!");
        fortunes.add("Something unexpected will make you smile.");
        fortunes.add("A new opportunity is coming soon.");
        fortunes.add("Happiness is around the corner.");
        fortunes.add("Trust your instincts.");
        fortunes.add("Adventure awaits you.");
        fortunes.add("Someone appreciates you more than you know.");
        fortunes.add("A pleasant surprise is coming.");
        fortunes.add("Your hard work will pay off.");
        fortunes.add("You will make a new friend soon.");
        fortunes.add("Take a chance today.");
        fortunes.add("Good luck will find you.");


        setSize(500, 500);



        createTopPanel();
        createMiddlePanel();
        createBottomPanel();


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);







    }

    public void createTopPanel() {
        // Create panel
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Create label with text and icon
        JLabel label = new JLabel("Fortune Teller");
        label.setIcon(new ImageIcon("fortune_teller.jpg"));
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setFont(new Font(Font.SANS_SERIF,Font.ITALIC | Font.BOLD,40));// small icon for the label
        topPanel.add(label);

        // Add topPanel to the frame (assumes this is inside a JFrame subclass)
        add(topPanel, BorderLayout.NORTH);

        // Set the window icon (this is for the JFrame, not the panel)
        setIconImage(new ImageIcon("fortune_teller.jpg").getImage());

        setTitle("Fortune Teller");
    }

    public void createMiddlePanel(){

        textArea.setFont(new Font("TimesRoman", Font.PLAIN, 18));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        textArea.setRows(10);
        textArea.setColumns(20);

        JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        middlePanel.add(scrollPane);


        // Add middlePanel to frame
        add(middlePanel, BorderLayout.CENTER);




    }

    public void createBottomPanel(){
        JButton button = new JButton("Read my fortune");
        button.setFont(new Font("Monospaced", Font.PLAIN, 18));
        button.setSize(20,20);
        button.addActionListener(e -> {


            int index;
            if (!repeat.isEmpty()) {
                do {
                    index = generator.nextInt(fortunes.size());
                } while (index == repeat.getLast()); // keep picking until it’s different
            } else{
                index = generator.nextInt(fortunes.size());
            }

            repeat.add(index); // store for next time
            textArea.append(fortunes.get(index) + "\n");
        });


        JButton quit = new JButton("Quit");
        quit.setFont(new Font("Monospaced", Font.PLAIN, 18));
        quit.addActionListener(e -> System.exit(0));


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(button);
        buttonPanel.add(quit);

        add(buttonPanel, BorderLayout.SOUTH);



    }


}
