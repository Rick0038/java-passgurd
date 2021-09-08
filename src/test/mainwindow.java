package test;

import javax.swing.*;

public class mainwindow extends JFrame{

    ImageIcon image = new ImageIcon("assets/test.png");
    /* import the software icon and sets it inside image variable */

    mainwindow()
    {
        this.setTitle("Demo window");
        /* sets the title bar string */
        this.setSize(800,600);
        /* sets the default window size */
        this.setVisible(true);
        /* makes the spawned window visible */
        this.setDefaultCloseOperation(mainwindow.EXIT_ON_CLOSE);
        /* sets the close action to kill the process */
        this.setIconImage(image.getImage());
        /* set the icon of the software to the value stored inside the image variable */
    }
}
