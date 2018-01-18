import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.util.concurrent.TimeUnit;

// An AWT program inherits from the top-level container java.awt.Frame
public class dataGui extends Frame implements ActionListener, WindowListener {
	private Label lbl_array, lbl_output;    // Declare a Label component 
	private TextField tf_array, tf_output; // Declare a TextField component 
	private Button btn_sort, btn_range, btn_avg, btn_arr, btn_add;   // Declare a Button component
	private int arr_size, count;     // Counter's value
	private double min, max, avg;
	private double[] arr;
	 
	// Constructor to setup GUI components and event handlers
	public dataGui () {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		// "super" Frame, which is a Container, sets its layout to FlowLayout to arrange
		
		arr_size = 1;
		min = 0; max = 0; avg = 0;
		lbl_array = new Label("Number of Data Points:");  // construct the Label component
		lbl_array.setFont(new Font("Serif", Font.PLAIN, 36));
		
		add(lbl_array);                    // "super" Frame container adds Label component
		
		
	 
		tf_array = new TextField("", 5); // construct the TextField component
		tf_array.setEditable(true);       // set to read-only
		tf_array.setFont(new Font("Courier New", Font.PLAIN, 36));
		add(tf_array);   // "super" Frame container adds TextField component
		
		
		lbl_output = new Label("Data Output:");
		lbl_output.setFont(new Font("Serif", Font.BOLD, 36));
		add(lbl_output);
		
		tf_output = new TextField("", 20);
		tf_output.setEditable(false);
		tf_output.setFont(new Font("Courier New", Font.PLAIN, 36));
		add(tf_output);
		
		btn_arr = new Button("Set Array Size");   // construct the Button component
		//btn_arr.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		add(btn_arr);                    // "super" Frame container adds Button component
		
		btn_add = new Button("Add");
		add(btn_add);
		
		
		btn_arr.addActionListener(this);
		
		btn_add.addActionListener(this);
		// Clicking "btnCount" invokes actionPerformed().
		
		addWindowListener(this);
		
		setTitle("The Data Calculator");  // "super" Frame sets its title
		setSize(750, 400);        // "super" Frame sets its initial window size
		setVisible(true);         // "super" Frame shows
	}

	public static void main(String[] args) {
		dataGui app = new dataGui();
	}
	
	
	// ActionEvent handler - Called back upon button-click.
	@Override
	public void actionPerformed(ActionEvent evt) {
		String cmd = evt.getActionCommand();
		if(!tf_array.getText().equals("") && cmd.equals("Set Array Size")){
			arr_size = Integer.parseInt(tf_array.getText());
			arr = new double[arr_size];
			count = 0;
			tf_array.setText("");
		}
		else if(!tf_array.getText().equals("") && cmd.equals("Add")){
			arr[count] = Double.parseDouble(tf_array.getText());
			count++;
			tf_array.setText("");
		}
		
		else{
			tf_output.setText(cmd);
		}
		
		
		
		
		//System.exit(0);
	}
	
	@Override
	public void windowClosing(WindowEvent evt){
		System.exit(0);
	}
	//Must be overridden since we are implementing an interface
	@Override public void windowOpened(WindowEvent evt) { }
	@Override public void windowClosed(WindowEvent evt) { }
	@Override public void windowIconified(WindowEvent evt) { }
	@Override public void windowDeiconified(WindowEvent evt) { }
	@Override public void windowActivated(WindowEvent evt) { }
	@Override public void windowDeactivated(WindowEvent evt) { }
}

