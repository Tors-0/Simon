import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Scene {
    // Variables:
    // Field variables
    private int height;
    private int width;
    private String windowName;
    // User settings
    private static Color bgColor = Color.WHITE;
    private static Font btnFont  = new Font(Font.SANS_SERIF, Font.PLAIN,  25);
    private static Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD,  50);
    private static Font labelFont = new Font(Font.SANS_SERIF, Font.PLAIN,  30);

    // Constructors:
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

        JPanel secondaryMenu = new JPanel();
        secondaryMenu.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        secondaryMenu.setBackground(bgColor);

        JLabel title = new JLabel("Simon");
        title.setFont(titleFont);
        title.setBorder(new EmptyBorder(15,5,20,0));
        mainMenu.add(title);

        JButton startBtn = createBtn("Play", mainMenu);
        JButton optionBtn = createBtn("Options", mainMenu);
        JButton aboutBtn = createBtn("About", mainMenu);

        JLabel about = new JLabel("Welcome to Simon.");
        about.setFont(labelFont);

        JLabel options = new JLabel("Options.");
        options.setFont(labelFont);

        secondaryMenu.add(about);
        secondaryMenu.add(options);
        about.setVisible(false);
        options.setVisible(false);

        menuContainer.add(mainMenu);
        menuContainer.add(secondaryMenu);
        frame.add(menuContainer);

        startBtn.addActionListener(e -> Main.startGame());

        optionBtn.addActionListener(e -> {
            about.setVisible(false);
            options.setVisible(true);
        });

        aboutBtn.addActionListener(e -> {
            options.setVisible(false);
            about.setVisible(true);
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
}
