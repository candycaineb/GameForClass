
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Caine
 */
public class MessagesMenu extends javax.swing.JPanel {
   private static CheckersController CC = new CheckersController(); 
   private static DefaultListModel userList = new DefaultListModel();
    /**
     * Creates new form MessagesMenu
     */
    public MessagesMenu() {
        initComponents();
    
        PublicMsgBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    CC.SendPublicMsg(PublicMsgTxt.getText());
                    PublicMsgTxt.setText("");
                } });
        PrivateMsgBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    if (UsersList.getSelectedValue() != null) {
                        CC.SendPrivateMsg((String)UsersList.getSelectedValue(), PrivateMsgTxt.getText());
                        String tempMsg = CheckersController.PrivateMsgs.get((String)UsersList.getSelectedValue());
                        tempMsg += CheckersController.client._username + " : " + PrivateMsgTxt.getText() + "\n";
                        CheckersController.PrivateMsgs.put((String)UsersList.getSelectedValue(), tempMsg);
                        Update();
                        PrivateMsgTxt.setText("");
                    }
                } });
        UsersList.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mousePressed(MouseEvent e){
                if (UsersList.getSelectedValue() != null) {
                PrivateMsgForum.setText(CheckersController.PrivateMsgs.get((String)UsersList.getSelectedValue()));
                }
            }
        });
        Update();
    }
    public static void Update(){
        if (UsersList.getSelectedValue() != null) {
            PrivateMsgForum.setText(CheckersController.PrivateMsgs.get((String)UsersList.getSelectedValue()));
        }
        PublicMsgForum.setText(CheckersController.PublicMsgs);//CheckersController.PublicMsgs);
        //UsersList.clearSelection();
        userList.clear();
        Set s = CheckersController.PrivateMsgs.keySet();
        Iterator i = s.iterator();
        while (i.hasNext()){   
            userList.addElement(i.next());
        }
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        PublicMsgForum = new javax.swing.JTextArea();
        PublicMsgTxt = new javax.swing.JTextField();
        PublicMsgBtn = new javax.swing.JButton();
        label3 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        PrivateMsgForum = new javax.swing.JTextArea();
        PrivateMsgTxt = new javax.swing.JTextField();
        PrivateMsgBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        UsersList =  new JList(userList);
        label4 = new java.awt.Label();

        label1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label1.setText("Public Messages");

        PublicMsgForum.setEditable(false);
        PublicMsgForum.setColumns(20);
        PublicMsgForum.setRows(5);
        jScrollPane1.setViewportView(PublicMsgForum);

        PublicMsgTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublicMsgTxtActionPerformed(evt);
            }
        });

        PublicMsgBtn.setText("Send");

        label3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label3.setText("Private Messages");

        PrivateMsgForum.setEditable(false);
        PrivateMsgForum.setColumns(20);
        PrivateMsgForum.setRows(5);
        jScrollPane3.setViewportView(PrivateMsgForum);

        PrivateMsgTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrivateMsgTxtActionPerformed(evt);
            }
        });

        PrivateMsgBtn.setText("Send");

        jScrollPane2.setViewportView(UsersList);

        label4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label4.setText("Users");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PublicMsgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(PublicMsgBtn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(63, 63, 63)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PrivateMsgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PrivateMsgBtn)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrivateMsgBtn)
                    .addComponent(PrivateMsgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PublicMsgBtn)
                    .addComponent(PublicMsgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PublicMsgTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublicMsgTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PublicMsgTxtActionPerformed

    private void PrivateMsgTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrivateMsgTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrivateMsgTxtActionPerformed
private javax.swing.JButton PrivateMsgBtn;
    private static javax.swing.JTextArea PrivateMsgForum;
    private javax.swing.JTextField PrivateMsgTxt;
    private javax.swing.JButton PublicMsgBtn;
    private static javax.swing.JTextArea PublicMsgForum;
    private static javax.swing.JTextField PublicMsgTxt;
    public static javax.swing.JList UsersList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.Label label1;
    private java.awt.Label label3;
    private java.awt.Label label4;
    /*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PrivateMsgBtn;
    private javax.swing.JTextArea PrivateMsgForum;
    private javax.swing.JTextField PrivateMsgTxt;
    private javax.swing.JButton PublicMsgBtn;
    private javax.swing.JTextArea PublicMsgForum;
    private javax.swing.JTextField PublicMsgTxt;
    private javax.swing.JList UsersList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.Label label1;
    private java.awt.Label label3;
    private java.awt.Label label4;
    // End of variables declaration//GEN-END:variables
*/
}
