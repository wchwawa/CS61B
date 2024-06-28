package game2048rendering;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class KeyEventTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("KeyEvent Test");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.requestFocus();

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                printKeyEventInfo(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                printKeyEventInfo(e);
            }

            @Override
            public void keyTyped(KeyEvent e) {
                printKeyEventInfo(e);
            }

            private void printKeyEventInfo(KeyEvent e) {
                System.out.println("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
                System.out.println("Key Code: " + e.getKeyCode());
                System.out.println("Key Char: " + e.getKeyChar());
                System.out.println("Modifiers: " + KeyEvent.getModifiersExText(e.getModifiersEx()));
                System.out.println("Key Location: " + getKeyLocation(e.getKeyLocation()));
                System.out.println("-------------------");
            }

            private String getKeyLocation(int keyLocation) {
                switch (keyLocation) {
                    case KeyEvent.KEY_LOCATION_STANDARD:
                        return "Standard";
                    case KeyEvent.KEY_LOCATION_LEFT:
                        return "Left";
                    case KeyEvent.KEY_LOCATION_RIGHT:
                        return "Right";
                    case KeyEvent.KEY_LOCATION_NUMPAD:
                        return "Numpad";
                    default:
                        return "Unknown";
                }
            }
        });
    }
}
