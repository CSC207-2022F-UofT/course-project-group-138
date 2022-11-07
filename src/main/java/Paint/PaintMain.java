package Paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintMain {

    JButton clearBtn, blackBtn, redBtn, blueBtn, greenBtn, eraserBtn,
            doneBtn, size1Btn, size2Btn, size3Btn, size4Btn;
    JButton lastButton = blackBtn;

    DrawArea drawArea;
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn){
                drawArea.clear();
            } else if (e.getSource() == blackBtn) {
                drawArea.black();
                blackBtn.setBackground(Color.gray);
                lastButton.setBackground(Color.white);
                lastButton = blackBtn;
            } else if (e.getSource() == redBtn){
                drawArea.red();
                redBtn.setBackground(Color.red);
                lastButton.setBackground(Color.white);
                lastButton = redBtn;
            } else if (e.getSource() == blueBtn) {
                drawArea.blue();
                blueBtn.setBackground(Color.blue);
                lastButton.setBackground(Color.white);
                lastButton = blueBtn;
            } else if (e.getSource() == greenBtn) {
                drawArea.green();
                greenBtn.setBackground(Color.green);
                lastButton.setBackground(Color.white);
                lastButton = greenBtn;
            } else if (e.getSource() == eraserBtn) {
                drawArea.eraser();
                eraserBtn.setBackground(Color.gray);
                lastButton.setBackground(Color.white);
                lastButton = eraserBtn;
            } else if (e.getSource() == size1Btn) {
                drawArea.size1();
                size1Btn.setBackground(Color.gray);
                lastButton.setBackground(Color.white);
                lastButton = size1Btn;
            } else if (e.getSource() == size2Btn) {
                drawArea.size2();
                size2Btn.setBackground(Color.gray);
                lastButton.setBackground(Color.white);
                lastButton = size2Btn;
            } else if (e.getSource() == size3Btn) {
                drawArea.size3();
                size3Btn.setBackground(Color.RED);
                lastButton.setBackground(Color.white);
                lastButton = size3Btn;
            } else if (e.getSource() == size4Btn) {
                drawArea.size4();
                size4Btn.setBackground(Color.gray);
                lastButton.setBackground(Color.white);
                lastButton = size4Btn;
            } else if (e.getSource() == doneBtn){
                drawArea.done();
                // add save code
                // add exit code
            }
            lastButton.setOpaque(true);
            lastButton.setBorderPainted(false);
        }
    };

    public static void main(String[] args) {
        new PaintMain().show();
    }

    public void show(){
        JFrame frame = new JFrame("uwu");
        Container contents = frame.getContentPane();
        contents.setLayout(new BorderLayout());

        drawArea = new DrawArea();

        contents.add(drawArea, BorderLayout.CENTER);

        JPanel controls = new JPanel();
        JPanel sizes = new JPanel();
        clearBtn = new JButton("clear");
        blackBtn = new JButton("black");
        redBtn = new JButton("red");
        blueBtn = new JButton("blue");
        greenBtn = new JButton("green");
        doneBtn = new JButton("done");
        eraserBtn = new JButton("erase");

        size1Btn = new JButton("1");
        size2Btn = new JButton("2");
        size3Btn = new JButton("3");
        size4Btn = new JButton("4");
        JButton[] controlChoices = {clearBtn, eraserBtn, blackBtn, redBtn, blueBtn, greenBtn, doneBtn};
        JButton[] sizeChoices = {size1Btn, size2Btn, size3Btn, size4Btn};

        for (JButton c: controlChoices){
            c.addActionListener(actionListener);
            controls.add(c);
        }

        for (JButton s: sizeChoices){
            s.addActionListener(actionListener);
            sizes.add(s);
        }

        contents.add(controls, BorderLayout.NORTH);
        contents.add(sizes, BorderLayout.SOUTH);


        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

