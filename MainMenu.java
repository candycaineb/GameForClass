
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MainMenu {

        JButton CreateTblbtn = new JButton("Create Table");
        JButton PrivateMsgbtn = new JButton("Private Message");
        JButton ObserveTblbtn = new JButton("Observe Table");
        JButton JoinTablebtn = new JButton("Join Table");
        JButton PublicMsgbtn = new JButton("Public Message");
        final TextArea publicMsgs;
        final JTextField typedMsg ;
        private String _publicChat = "";
	MainMenu(){
            JFrame f = new JFrame("Checkers Main Menu");
            f.setLayout(new GridLayout(0, 2, 15, 15));
            f.setSize(220, 200);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 0, 15, 15));
            f.add(panel);
            JPanel panel2 = new JPanel();
            
            panel2.setLayout(new GridLayout(6, 0, 15, 15));
            //panel2.set
            f.add(panel2);
            
            
            
          
            PrivateMsgbtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                   // cmds.Redo();
                }
             });
            
            
            
            panel2.add(CreateTblbtn);
            panel2.add(JoinTablebtn);
            panel2.add(ObserveTblbtn);
            panel2.add(PrivateMsgbtn);
            panel2.add(PublicMsgbtn);
            
            
            publicMsgs = new TextArea();
            publicMsgs.setBackground(Color.WHITE);
            panel.add(publicMsgs);
            
            typedMsg = new JTextField(20);
            typedMsg.setBackground(Color.WHITE);
            panel.add(typedMsg);
            
            f.pack();
            f.setVisible(true);
            
        }
        public void ConcatPulicChat(String usr, String s){
            _publicChat += usr + " : "+ s + "\n";
            publicMsgs.setText("Public Message Forum\n" + _publicChat);
        }
        public String GetMsgField(){
            String s = typedMsg.getText();
            typedMsg.setText("");
            return s;
        }
}