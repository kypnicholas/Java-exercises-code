import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


public class mediaPlayer {
	
	public static class mySwing extends JFrame implements ActionListener
	{
		JFrame frame = new JFrame("Demo");
		JPanel myPanel, trackControlsPanel, nowPlayingPanel;
		JButton playTrack, previousTrack, nextTrack, pauseTrack, volumeUp, volumeDown;
		JLabel navigationsLabel, nowPlayingLabel, progressBarLabel;
		JMenuBar menuBar;
		JMenuItem fileExitMenuItem;
		Container contentPane;
		JScrollPane scrollPane;
		
		
		public mySwing()
		{
			/// Contents and navigation panel
			myPanel = new JPanel(new GridBagLayout());
			GridBagConstraints left = new GridBagConstraints();
			left.anchor = GridBagConstraints.EAST;
	        GridBagConstraints right = new GridBagConstraints();
	        right.weightx = 2.0;
	        right.fill = GridBagConstraints.HORIZONTAL;
	        right.gridwidth = GridBagConstraints.REMAINDER;
	        
	        /// Track controls panel
	        trackControlsPanel = new JPanel (new FlowLayout());
	        playTrack = new JButton("Play");
	        playTrack.addActionListener(this);
	        pauseTrack = new JButton("Pause");
			previousTrack = new JButton("Previous");
			nextTrack = new JButton("Next");
			progressBarLabel = new JLabel("this needs to be replaced by a progress bar !!!"); 
			Border border1 = BorderFactory.createLineBorder(Color.BLUE, 2);
			progressBarLabel.setBorder(border1);
			progressBarLabel.setPreferredSize(new Dimension(700, 25));
			
			/// Now-Playing panel
			nowPlayingPanel = new JPanel (new FlowLayout());
			nowPlayingLabel = new JLabel("Now Playing"); 
			Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
			nowPlayingLabel.setBorder(border);
			nowPlayingLabel.setPreferredSize(new Dimension(775, 25));
			volumeUp = new JButton("Volume Up");
			volumeDown = new JButton("Volume Down");
			
			//////// Menu bar	
			menuBar = new JMenuBar();
			menuBar.setOpaque(true);
			menuBar.setPreferredSize(new Dimension(1600, 25));
			JMenu fileMenu = new JMenu("File");
			JMenu helpMenu = new JMenu("Help");
			
			fileExitMenuItem = new JMenuItem("Exit");
			fileExitMenuItem.addActionListener(this); 			
				
			
			////// Contents section 			
			//// contents table
			String[] columnNames = {"Track", "Artist", "Album"};
			Object[][] data = {{"Kathy", "Smith","Snowboarding"}};
			
			JTable contentsTable = new JTable(data, columnNames);
			scrollPane = new JScrollPane(contentsTable);
			//contentsTable.setFillsViewportHeight(true);
			contentsTable.setBackground(Color.LIGHT_GRAY);
			contentsTable.setOpaque(true);
			contentsTable.setPreferredSize(new Dimension(1200, 800));
			
			////// Navigation section -- this should change (with a JTable or something similar)
			navigationsLabel = new JLabel();
			navigationsLabel.setOpaque(true);
			navigationsLabel.setBackground(Color.white);
			navigationsLabel.setPreferredSize(new Dimension(300, 800));
			
			//////// Page layout
			contentPane = getContentPane();
			contentPane.setLayout(new FlowLayout());
			contentPane.add(menuBar, BorderLayout.LINE_START);
			
			contentPane.add(contentsTable, left);
			contentPane.add(navigationsLabel, right);
			

			menuBar.add(fileMenu);
			menuBar.add(helpMenu);
			fileMenu.add(fileExitMenuItem);
			this.add(menuBar);				
			trackControlsPanel.add(playTrack);
			trackControlsPanel.add(pauseTrack);
			trackControlsPanel.add(previousTrack);
			trackControlsPanel.add(nextTrack);
			trackControlsPanel.add(progressBarLabel);
			this.add(trackControlsPanel);
			nowPlayingPanel.add(nowPlayingLabel);
			nowPlayingPanel.add(volumeUp);
			nowPlayingPanel.add(volumeDown);
			this.add(nowPlayingPanel);
			myPanel.add(contentsTable.getTableHeader());			
			myPanel.add(contentsTable);
			myPanel.add(navigationsLabel);
			this.add(myPanel);	
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			///// test
			if(event.getSource()==playTrack)
			{
				navigationsLabel.setText("HI!");
			}	
			
			//// Menu >> Exit system
			if(event.getSource()==fileExitMenuItem)
			{
				System.exit(0);
			}	
		}
		
	}
	public static void main(String[] args) {
		
		JFrame frame = new mySwing();
		frame.setTitle("Juke Box");
		//frame.setSize(1200,800);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	
}
