import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField, emailTextField, secnoTextField, addrTextField, cityTextField, natTextField, pinTextField;
    JButton next;
    JDateChooser dateChooser;
    JRadioButton male, female;
    SignupOne() {
        setLayout(null);

        Random ran = new Random();
//        System.out.println(Math.abs((ran.nextLong() % 9000L) + 1000L));
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);


        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personDetails = new JLabel("Page 1. Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 190, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 190, 200, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel secno = new JLabel("Security Number: ");
        secno.setFont(new Font("Raleway", Font.BOLD, 20));
        secno.setBounds(100, 240, 200, 30);
        add(secno);

        secnoTextField = new JTextField();
        secnoTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        secnoTextField.setBounds(300, 240, 400, 30);
        add(secnoTextField);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290,100,30);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 290, 100, 30);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 390, 200, 30);
        add(address);

        addrTextField = new JTextField();
        addrTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addrTextField.setBounds(300, 390, 400, 30);
        add(addrTextField);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 440, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 440, 400, 30);
        add(cityTextField);

        JLabel nationality = new JLabel("Nationality: ");
        nationality.setFont(new Font("Raleway", Font.BOLD, 20));
        nationality.setBounds(100, 490, 200, 30);
        add(nationality);

        natTextField = new JTextField();
        natTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        natTextField.setBounds(300, 490, 400, 30);
        add(natTextField);

        JLabel pin = new JLabel("Pin Code: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 540, 200, 30);
        add(pin);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 540, 400, 30);
        add(pinTextField);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 600, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random; //long
        String name = nameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailTextField.getText();
        String address = addrTextField.getText();
        String city = cityTextField.getText();
        String nationality = natTextField.getText();
        String pin = pinTextField.getText();

        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required.");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+dob+"', '"+gender+"', '"+email+"', '"+address+"', '"+city+"', '"+nationality+"', '"+pin+"')";
                c.s.executeUpdate(query);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]){
        new SignupOne();
    }
}
