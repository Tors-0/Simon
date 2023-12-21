import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Scene {
    // Variables:
    // Field variables
    private int height; // The width of the window
    private int width; // The height of the window
    private String windowName; // The name of the window
    // User settings
    private static Color bgColor = Color.WHITE; // The background color of the game
    private static Font btnFont  = new Font(Font.SANS_SERIF, Font.PLAIN,  25); // The font for buttons
    private static Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD,  50); // The font for the title
    private static Font textFont = new Font(Font.SANS_SERIF, Font.PLAIN,  15); // The font for labels

    /**
     * The default constructor.
     * @author Kiefer Menard
     * @param width The width of the window
     * @param height The height of the window
     * @param windowName The name of the window
     */
    public Scene(int width, int height, String windowName) {
        // Variables
        this.height = height;
        this.width = width;
        this.windowName = windowName;

        initialize();
    }

    private void initialize() {
        JFrame frame = new JFrame();

        frame.setTitle(windowName);
        frame.setLayout(new BorderLayout(10, 5));
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel menuContainer = new JPanel();
        menuContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        menuContainer.setBackground(bgColor);

        JPanel mainMenu = new JPanel();
        mainMenu.setLayout(new GridLayout(4, 1));
        mainMenu.setBackground(bgColor);

        JPanel optionsMenu = new JPanel();
        optionsMenu.setLayout(new GridLayout(3, 1, 10, 10));
        optionsMenu.setBackground(bgColor);

        JPanel aboutMenu = new JPanel();
        aboutMenu.setLayout(new GridLayout(3, 1, 10, 10));
        aboutMenu.setBackground(bgColor);

        JLabel title = new JLabel("Simon");
        title.setFont(titleFont);
        title.setBorder(new EmptyBorder(15,5,20,0));
        mainMenu.add(title);

        JButton startBtn = createBtn("Play", mainMenu);
        JButton optionBtn = createBtn("Options", mainMenu);
        JButton aboutBtn = createBtn("About", mainMenu);

        JLabel options = new JLabel("Options.");
        options.setFont(textFont);

        JTextArea about = createText("Welcome to Simon.\n\nHow to play:\nThere are 4 buttons colored red, green, blue, and yellow.\nOne of the buttons will flash and you have to click that same one.\nAfter that the one that just flashed will flash again followed by a second flash on another button.\nYou then have to click those buttons following the pattern.\nThis will continue each time getting 1 flash longer until you incorrectly repeat the pattern.\n\nMade by Kiefer Menard.", aboutMenu);

        aboutMenu.add(about);

        menuContainer.add(mainMenu);
        menuContainer.add(optionsMenu);
        optionsMenu.setVisible(false);
        menuContainer.add(aboutMenu);
        aboutMenu.setVisible(false);
        frame.add(menuContainer);

        startBtn.addActionListener(e -> Main.startGame());

        optionBtn.addActionListener(e -> {
            aboutMenu.setVisible(false);
            optionsMenu.setVisible(true);
        });

        aboutBtn.addActionListener(e -> {
            optionsMenu.setVisible(false);
            aboutMenu.setVisible(true);
        });

        frame.setVisible(true);
    }

    public JButton createBtn(String text, JPanel panel) {
        JButton button = new JButton(text);
        button.setFont(btnFont);
        button.setMargin(new Insets(2, 5, 2, 5));

        panel.add(button);

        return button;
    }

    public JTextArea createText(String text, JPanel panel) {
        JTextArea label = new JTextArea(text);
        label.setFont(textFont);

        panel.add(label);

        return label;
    }
}
