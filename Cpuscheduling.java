// NAME: Illisha Singh
// Roll Number: 1710110146
package OSGLA1;

//all the imports exist below
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Cpuscheduling {

    public static void main(String[] args) { //main class
        try {
            JFrame frame = new JFrame("CPU Scheduling"); //the Scheduling frame with its properties as below
            frame.setLayout(new GridLayout(9, 1));
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            /*panel 1 containing the dropdown to select the number of processors*/
            JPanel panel1 = new JPanel();
            /*panel 2 containing the textarea to enter the burst time*/
            JPanel panel2 = new JPanel();
            /*panel 3 containing the textarea to enter the arrival time*/
            JPanel panel3 = new JPanel();
            /*panel 4 containing the textarea to enter the priorities*/
            JPanel panel4 = new JPanel();
            /*panel 5 containing the textarea to enter the quanta time*/
            JPanel panel5 = new JPanel();

            /*panels 6-9 contain the checkboxes for the available gantt chart options*/
            JPanel panel6 = new JPanel(new GridLayout(1, 2));
            JPanel panel7 = new JPanel(new GridLayout(1, 2));
            JPanel panel8 = new JPanel(new GridLayout(1, 2));

            //panel 9 contains the compute button
            JPanel panel9 = new JPanel();

            JLabel label1 = new JLabel("Number of processes (<=6)    ");

            String[] dropdownMenu = {"P1", "P2", "P3", "P4", "P5", "P6"}; /*defining the dropdown menu for the number of processors*/

            JComboBox dropdown = new JComboBox(dropdownMenu);

            /*defining the labels for the various inputs to be given*/
            JLabel burstTimeLabel = new JLabel("Burst Time ");
            burstTimeLabel.setAlignmentX(0);
            JLabel arrivalTimeLabel = new JLabel("Arrival Time ");
            arrivalTimeLabel.setAlignmentY(0);
            JLabel priorityLabel = new JLabel("Priority ");
            priorityLabel.setAlignmentY(0);
            JLabel timeQuantumLabel = new JLabel("Time Quantum ");
            timeQuantumLabel.setAlignmentY(0);

            /*defining the textareas for the various inputs to be given*/
            JTextArea burstTime = new JTextArea(1, 30);
            JTextArea arrivalTime = new JTextArea(1, 30);
            JTextArea priority = new JTextArea(1, 30);
            JTextArea timeQuantum = new JTextArea(1, 30);

            /*defining the checkboxes for the gantt charts that need to be displayed*/
            JCheckBox FCFS = new JCheckBox("FCFS");
            JCheckBox RoundRobin = new JCheckBox("Round Robin");
            JCheckBox PreemptiveSJF = new JCheckBox("Preemptive SJF");
            JCheckBox NonPreemptiveSJF = new JCheckBox("Non-Preemptive SJF");
            JCheckBox PreemptivePriority = new JCheckBox("Preemptive Priority");
            JCheckBox NonPreemptivePriority = new JCheckBox("Non-Preemptive Priority");

            JButton compute = new JButton("Compute");

            /*the above listed components are added to their respective panels*/
            panel1.add(label1);
            panel1.add(dropdown);
            panel2.add(burstTimeLabel);
            panel2.add(burstTime);
            panel3.add(arrivalTimeLabel);
            panel3.add(arrivalTime);
            panel4.add(priorityLabel);
            panel4.add(priority);
            panel5.add(timeQuantumLabel);
            panel5.add(timeQuantum);

            panel6.add(FCFS);
            panel6.add(RoundRobin);
            panel7.add(PreemptiveSJF);
            panel7.add(NonPreemptiveSJF);
            panel8.add(PreemptivePriority);
            panel8.add(NonPreemptivePriority);

            panel9.add(compute);

            //adding functionality to the compute button
            compute.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frameGantt = new JFrame("Gantt Chart"); /*The frame that gets displayed on click of the button*/

                    //setting the parameters of the gantt chart frame
                    frameGantt.setLayout(new GridLayout(24, 1));

                    frameGantt.setSize(1015, 700);
                    frameGantt.setLocationRelativeTo(null);
                    frameGantt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    //defining different panels for the frame corresponding to each checkbox
                    JPanel panel1 = new JPanel(null); //panel for fcfs
                    JPanel panel2 = new JPanel(new BorderLayout());
                    JPanel panel1_1 = new JPanel(new GridLayout(2, 1));
                    JPanel panel2_2 = new JPanel(null);

                    JPanel panel3 = new JPanel(null); //panel for non preemptive sjf
                    JPanel panel4 = new JPanel(new BorderLayout());
                    JPanel panel3_3 = new JPanel(new GridLayout(2, 1));
                    JPanel panel4_4 = new JPanel(null);

                    JPanel panel5 = new JPanel(null); //panel for round robin
                    JPanel panel6 = new JPanel(new BorderLayout());
                    JPanel panel5_5 = new JPanel(null);
                    JPanel panel6_6 = new JPanel(new GridLayout(2, 1));

                    JPanel panel7 = new JPanel(null); //panel for non preemptive priority
                    JPanel panel8 = new JPanel(new BorderLayout());
                    JPanel panel8_8 = new JPanel(null);
                    JPanel panel7_7 = new JPanel(new GridLayout(2, 1));

                    JPanel panel9 = new JPanel(null); //panel for preemptive sjf
                    JPanel panel10 = new JPanel(new BorderLayout());
                    JPanel panel10_10 = new JPanel(null);
                    JPanel panel9_9 = new JPanel(new GridLayout(2, 1));

                    JPanel panel11 = new JPanel(null); //panel for preemptive priority
                    JPanel panel12 = new JPanel(new BorderLayout());
                    JPanel panel11_11 = new JPanel(null);
                    JPanel panel12_12 = new JPanel(new GridLayout(2, 1));

                    //4 strings for the 4 lines of input to be taken from the user
                    String s1 = new String(); //string for burst time input
                    String s2 = new String(); //string for arrival time input
                    String s3 = new String(); //string for priorities
                    String s4 = new String(); //string that takes in the time slice input
                    try {
                        s1 = burstTime.getText() + ",";
                        s2 = arrivalTime.getText() + ",";
                        s3 = priority.getText() + ",";
                        s4 = timeQuantum.getText();
                    } catch (Exception ex) {
                        ex = new Exception(); //exception caught in cases where the input does not contain data
                    }

                    //FCFS checked
                    if (FCFS.isSelected()) {
                        JLabel FCFS = new JLabel("FCFS: ");
                        FCFS.setFont(new Font("Ariel", Font.BOLD, 15));
                        panel2.add(FCFS, (BorderLayout.WEST));
                        int[] a = new int[dropdown.getSelectedIndex() + 1];
                        int[] b = new int[dropdown.getSelectedIndex() + 1];
                        String[] sa = s1.split(",");
                        String[] sb = s2.split(",");
                        for (int i = 0; i < a.length; i++) {
                            a[i] = Integer.parseInt(sa[i]); //burst times
                            b[i] = Integer.parseInt(sb[i]); //arrival times
                        }
                        FCFS[] fcfs = new FCFS[a.length]; //class to store the fcfs data
                        int arrivalTime[] = new int[a.length]; //array to store the arrival times
                        int minTime = 10000;
                        int sum = 0;
                        for (int i = 0; i < fcfs.length; i++) {
                            fcfs[i] = new FCFS(i, a[i], b[i], true);
                            sum = sum + a[i];
                        }

                        //sorting data based on arrival times
                        for (int i = 0; i < a.length; i++) {
                            FCFS tempFcfs = fcfs[i];
                            for (int j = i + 1; j < a.length; j++) {
                                if (fcfs[i].arrival_time > fcfs[j].arrival_time) {
                                    fcfs[i] = fcfs[j];
                                    fcfs[j] = tempFcfs;
                                    tempFcfs = fcfs[i];
                                }

                                System.out.println(fcfs[i].burst_time + "bursttt");
                            }
                        }

                        frameGantt.add(panel2); //adding the FCFS label to panel

                        int temp = 0;
                        int temp1 = 0;
                        int c = 0;
                        int count = 0;

                        //generating labels for the gantt chart of fcfs
                        for (int i = 0; i < a.length; i++) {
                            temp = fcfs[i].burst_time;
                            JLabel j = new JLabel("P " + (fcfs[i].p_id + 1) + " = " + temp);
                            j.setBounds(c, 0, (int) (((double) temp / (double) sum) * 1000), 30);
                            Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
                            j.setBorder(border);
                            j.setBackground(white);
                            panel1.add(j);
                            panel1.repaint();

                            temp1 = temp1 + temp;
                            fcfs[i].completion = temp1;
                            fcfs[i].turn_around = fcfs[i].completion - fcfs[i].arrival_time;
                            fcfs[i].wait_time = fcfs[i].turn_around - fcfs[i].burst_time;
                            c += (((double) temp / (double) sum) * 1000);
                            System.out.println(c + "c");
                        }

                        frameGantt.add(panel1);
                        frameGantt.repaint();
                        temp = 0;
                        temp1 = 0;
                        c = 0;

                        //generating frames for the timeline of the chart
                        for (int i = 0; i < a.length; i++) {
                            temp = fcfs[i].burst_time;

                            JLabel k = new JLabel("" + (int) (temp1));
                            k.setBounds(c, 0, (int) (((double) temp / (double) sum) * 1000), 18);
                            Border border2 = BorderFactory.createLineBorder(Color.BLACK, 3);
                            k.setBorder(border2);
                            k.setBackground(white);
                            panel2_2.add(k);
                            panel2_2.repaint();
                            frameGantt.add(panel2_2);
                            frameGantt.repaint();
                            temp1 = temp1 + temp;
                            c += (((double) temp / (double) sum) * 1000);
                        }

                        //labels for the turn around time generated here
                        double avgtt = 0;
                        for (int i = 0; i < a.length; i++) {
                            JLabel j = new JLabel("Turn around P" + (i + 1) + "=" + fcfs[i].turn_around);
                            avgtt = avgtt + fcfs[i].turn_around;
                            panel1_1.add(j);
                            panel1_1.repaint();
                        }
                        double num = avgtt / a.length; //calculating average
                        DecimalFormat dec1 = new DecimalFormat("#0.00");
                        JLabel l = new JLabel("Average Turn_Around Time= " + (dec1.format(num)));
                        panel1_1.add(l);
                        panel1_1.repaint();

                        //generating wait times for the data 
                        double avgw = 0;
                        int value = 0;
                        for (int i = 0; i < a.length; i++) {
                            if (fcfs[i].wait_time < 0) {
                                value = 0;
                            } else {
                                value = fcfs[i].wait_time;
                            }
                            JLabel j = new JLabel("Waiting time P" + (i + 1) + " = " + value);
                            avgw = avgw + fcfs[i].wait_time;
                            panel1_1.add(j);
                            panel1_1.repaint();
                        }
                        double no = avgw / a.length; //calculating average
                        if (no <= 0) {
                            no = 0;
                        }
                        DecimalFormat dec = new DecimalFormat("#0.00");
                        JLabel j = new JLabel("Average Wait Time= " + (dec.format(no)));
                        panel1_1.add(j);
                        panel1_1.repaint();

                        frameGantt.add(panel1_1); //adding the panel containing wait and turn around times to the frame
                        frameGantt.repaint();
                    }

                    //Non preemtive SJF checked
                    if (NonPreemptiveSJF.isSelected()) {
                        JLabel chartNonPreemptiveSJF = new JLabel("Non-Preemptive SJF: "); //label for non preemptive sjf
                        chartNonPreemptiveSJF.setFont(new Font("Ariel", Font.BOLD, 15));
                        panel4.add(chartNonPreemptiveSJF, (BorderLayout.WEST));
                        int[] a = new int[dropdown.getSelectedIndex() + 1];
                        int[] b = new int[dropdown.getSelectedIndex() + 1];
                        String[] sa = s1.split(",");
                        String[] sb = s2.split(",");
                        for (int i = 0; i < a.length; i++) {
                            a[i] = Integer.parseInt(sa[i]); //burst times
                            b[i] = Integer.parseInt(sb[i]); //arrival times
                        }
                        process[] p = new process[a.length]; //class array for the inputs for SJF

                        for (int i = 0; i < a.length; i++) {
                            p[i] = new process((i), a[i], b[i], false);
                        }

                        int keys[] = new int[a.length];
                        Map process = new HashMap<Integer, Integer>(); //hasmap to track the process IDs and burst times
                        process.put(arrival(p, 0), p[arrival(p, 0)].burst_time);
                        keys[0] = arrival(p, 0);
                        p[keys[0]].done = true;
                        System.out.println("*/" + keys[0]);
                        int burstSum = p[arrival(p, 0)].burst_time;
                        System.out.println("burst sum " + burstSum);

                        //inputting the data into the process array
                        for (int i = 1; i < p.length; i++) {
                            process.put(arrival(p, burstSum), p[arrival(p, burstSum)].burst_time);
                            keys[i] = arrival(p, burstSum);
                            p[keys[i]].done = true;
                            System.out.println("**" + keys[i]);
                            burstSum = burstSum + p[arrival(p, burstSum)].burst_time;
                        }

                        int sum = a[0];
                        for (int i = 0; i < a.length - 1; i++) {
                            sum = sum + a[i + 1];
                        }
                        System.out.println("total " + sum);
                        int temp1 = 0;
                        int c = 0;
                        for (int i = 0; i < a.length; i++) {
                            System.out.println(p[keys[i]].burst_time + "nvm");
                        }

                        frameGantt.add(panel4); //adding the label panel

                        int temp = 0;
                        int temp2 = 0;

                        //generating the labels for the processes
                        for (int i = 0; i < a.length; i++) {
                            JLabel j = new JLabel("P " + (keys[i] + 1) + " = " + p[keys[i]].burst_time);
                            temp = (int) p[keys[i]].burst_time;
                            j.setBounds(c, 0, (int) (((double) temp / (double) sum) * 1000), 30);
                            Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
                            j.setBorder(border);
                            j.setBackground(white);
                            panel3.add(j);
                            panel3.repaint();
                            temp2 = temp2 + temp;
                            p[keys[i]].completion_time = temp2;
                            p[keys[i]].turn_around = p[keys[i]].completion_time - p[keys[i]].arrival_time;
                            p[keys[i]].wait_time = p[keys[i]].turn_around - p[keys[i]].burst_time;
                            c = c + (int) (((double) temp / (double) sum) * 1000);

                            System.out.println(c + "c");
                        }

                        temp = 0;
                        temp1 = 0;
                        c = 0;
                        //generating the timeline of the processes
                        for (int i = 0; i < a.length; i++) {
                            temp = (int) p[keys[i]].burst_time;
                            JLabel j = new JLabel("" + temp1);
                            j.setBounds(c, 0, (int) (((double) temp / (double) sum) * 1000), 18);
                            Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
                            j.setBorder(border);
                            j.setBackground(white);
                            panel4_4.add(j);
                            panel4_4.repaint();

                            c = c + (int) (((double) temp / (double) sum) * 1000);
                            temp1 = (int) p[keys[i]].burst_time + temp1;
                        }

                        //generating the turn around time labels
                        //turn around time = completion time - arrival time
                        double avgtt = 0;
                        for (int i = 0; i < a.length; i++) {
                            JLabel j = new JLabel("Turn around P" + (keys[i] + 1) + "=" + p[keys[i]].turn_around);
                            avgtt = avgtt + p[keys[i]].turn_around;
                            panel3_3.add(j);
                            panel3_3.repaint();
                        }
                        double num = avgtt / a.length; //average turn around time
                        DecimalFormat dec1 = new DecimalFormat("#0.00");
                        JLabel l = new JLabel("Average Turn_Around Time= " + (dec1.format(num)));

                        panel3_3.add(l);
                        panel3_3.repaint();

                        //generating the labels for the wait times
                        //wait time = turn around time - burst time
                        double avgw = 0;
                        int value = 0;
                        for (int i = 0; i < a.length; i++) {
                            if (p[keys[i]].wait_time < 0) {
                                value = 0;
                            } else {
                                value = p[keys[i]].wait_time;
                            }
                            JLabel j = new JLabel("Waiting time P" + (keys[i] + 1) + " = " + value);
                            avgw = avgw + p[keys[i]].wait_time;
                            panel3_3.add(j);
                            panel3_3.repaint();
                        }
                        double no = avgw / a.length; //average waiting time
                        if (no <= 0) {
                            no = 0;
                        }
                        DecimalFormat dec = new DecimalFormat("#0.00");
                        JLabel j = new JLabel("Average Wait Time= " + (dec.format(no)));

                        panel3_3.add(j);
                        panel3_3.repaint();

                        //adding all the panels to the chart
                        frameGantt.add(panel3);
                        frameGantt.add(panel4_4);
                        frameGantt.add(panel3_3);
                        frameGantt.repaint();
                        frameGantt.repaint();

                    }

                    //Non preemptive priority is checked
                    if (NonPreemptivePriority.isSelected()) {
                        JLabel chartNonpreemptivePriority = new JLabel("Non-Preemptive Priority: "); //generating the label
                        chartNonpreemptivePriority.setFont(new Font("Ariel", Font.BOLD, 15));
                        panel8.add(chartNonpreemptivePriority, (BorderLayout.WEST));

                        int[] a = new int[dropdown.getSelectedIndex() + 1];
                        int[] b = new int[dropdown.getSelectedIndex() + 1];
                        int[] c = new int[dropdown.getSelectedIndex() + 1];

                        String[] sa = s1.split(",");
                        String[] sb = s2.split(",");
                        String[] sc = s3.split(",");

                        for (int i = 0; i < a.length; i++) {
                            a[i] = Integer.parseInt(sa[i]); //burst times
                            b[i] = Integer.parseInt(sb[i]); //arrival times
                            c[i] = Integer.parseInt(sc[i]); //priorities
                        }
                        processPriority[] p = new processPriority[a.length]; //class array to store the related data

                        for (int i = 0; i < a.length; i++) {
                            p[i] = new processPriority((i), a[i], b[i], c[i], false);
                        }

                        int keys[] = new int[a.length];
                        Map process = new HashMap<Integer, Integer>(); //hashmap to map the process ids to the priorities
                        process.put(priorityCheck(p, 0), p[priorityCheck(p, 0)].priority);
                        keys[0] = priorityCheck(p, 0);
                        p[keys[0]].done = true;
                        System.out.println("*/" + keys[0]);

                        for (int i = 1; i < p.length; i++) {
                            process.put(priorityCheck(p, p[i - 1].priority), p[priorityCheck(p, p[i - 1].priority)].burst_time);
                            keys[i] = priorityCheck(p, p[i - 1].priority);
                            p[keys[i]].done = true;
                            System.out.println("**" + keys[i]);
                        }

                        int sum = a[0];
                        for (int i = 0; i < a.length - 1; i++) {
                            sum = sum + a[i + 1];
                        }
                        System.out.println("total " + sum);
                        int temp1 = 0;
                        int c1 = 0;
                        for (int i = 0; i < a.length; i++) {
                            System.out.println(p[keys[i]].burst_time + "nvm");
                        }

                        frameGantt.add(panel8); //panel containing the label

                        int temp = 0;
                        temp1 = 0;
                        //generating the labels for the processes in the required order
                        for (int i = 0; i < a.length; i++) {
                            JLabel j = new JLabel("P " + (keys[i] + 1) + " = " + p[keys[i]].burst_time);
                            temp = (int) p[keys[i]].burst_time;

                            j.setBounds(c1, 0, (int) (((double) temp / (double) sum) * 1000), 30);
                            Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
                            j.setBorder(border);
                            j.setBackground(white);
                            panel7.add(j);
                            panel7.repaint();
                            c1 = c1 + (int) (((double) temp / (double) sum) * 1000);
                            System.out.println(c1 + "c");
                            temp1 = temp1 + temp;
                            p[keys[i]].completion_time = temp1 + p[keys[i]].arrival_time;
                            p[keys[i]].turan_around = p[keys[i]].completion_time - p[keys[i]].arrival_time;
                            p[keys[i]].wait_time = p[keys[i]].turan_around - p[keys[i]].burst_time;
                        }

                        temp = 0;
                        temp1 = 0;
                        c1 = 0;
                        //generating the timeline labels
                        for (int i = 0; i < a.length; i++) {
                            JLabel j = new JLabel("" + temp1);
                            temp = (int) p[keys[i]].burst_time;
                            j.setBounds(c1, 0, (int) (((double) temp / (double) sum) * 1000), 18);
                            Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
                            j.setBorder(border);
                            j.setBackground(white);
                            panel8_8.add(j);
                            panel8_8.repaint();
                            c1 = c1 + (int) (((double) temp / (double) sum) * 1000);
                            System.out.println(c1 + "c");
                            temp1 = temp1 + temp;
                        }

                        //generating the turn around time labels 
                        //turn around time = completion time - arrival time
                        double avgtt = 0;
                        for (int i = 0; i < a.length; i++) {
                            JLabel j = new JLabel("Turn around P" + (keys[i] + 1) + "=" + p[keys[i]].turan_around);
                            avgtt = avgtt + p[keys[i]].turan_around;
                            panel7_7.add(j);
                            panel7_7.repaint();
                        }
                        double num = avgtt / a.length; //average turn around time
                        DecimalFormat dec1 = new DecimalFormat("#0.00");
                        JLabel l = new JLabel("Average Turn_Around Time= " + (dec1.format(num)));

                        panel7_7.add(l);
                        panel7_7.repaint();

                        //generating the average wait times
                        //wait time = turn around time - burst time
                        double avgw = 0;
                        int value = 0;
                        for (int i = 0; i < a.length; i++) {
                            if (p[keys[i]].wait_time < 0) {
                                value = 0;
                            } else {
                                value = p[keys[i]].wait_time;
                            }
                            JLabel j = new JLabel("Waiting time P" + (keys[i] + 1) + " = " + value);
                            avgw = avgw + p[keys[i]].wait_time;
                            panel7_7.add(j);
                            panel7_7.repaint();
                        }
                        double value2 = (avgw / a.length); //average wait time
                        if (value2 <= 0) {
                            value2 = 0;
                        }
                        double no = avgw / a.length;
                        DecimalFormat dec = new DecimalFormat("#0.00");
                        JLabel j = new JLabel("Average Wait Time= " + (dec.format(no)));

                        panel7_7.add(j);
                        panel7_7.repaint();

                        //adding all the panels to the frame
                        frameGantt.add(panel7);
                        frameGantt.add(panel8_8);
                        frameGantt.add(panel7_7);
                        frameGantt.repaint();
                    }

                    //Round Robin checked
                    if (RoundRobin.isSelected()) {
                        JLabel RoundRobin = new JLabel("Round Robin: "); //defining the heading label
                        RoundRobin.setFont(new Font("Ariel", Font.BOLD, 15));
                        panel6.add(RoundRobin, (BorderLayout.WEST));
                        int[] a = new int[dropdown.getSelectedIndex() + 1];
                        int[] b = new int[dropdown.getSelectedIndex() + 1];
                        int[] p = new int[dropdown.getSelectedIndex() + 1];
                        int quanta = Integer.parseInt(timeQuantum.getText()); //time quanta
                        String[] sa = s1.split(",");
                        String[] sb = s2.split(",");
                        for (int i = 0; i < a.length; i++) {
                            a[i] = Integer.parseInt(sa[i]); //burst times
                            b[i] = Integer.parseInt(sb[i]); //arrival times
                        }
                        Robin[] robin = new Robin[a.length]; //array of Robin class to store the data
                        int arrivalTime[] = new int[a.length];
                        int minTime = 10000;
                        int sum = 0;
                        for (int i = 0; i < robin.length; i++) {
                            robin[i] = new Robin(i, a[i], b[i], p[i], false);
                            sum = sum + a[i];
                        }

                        //sorting the array elements of robin class based on the arrival times
                        for (int i = 0; i < a.length; i++) {
                            Robin tempRobin = robin[i];
                            for (int j = i + 1; j < a.length; j++) {
                                if (robin[i].arrival_time > robin[j].arrival_time) {
                                    robin[i] = robin[j];
                                    robin[j] = tempRobin;
                                    tempRobin = robin[i];
                                }

                                System.out.println(robin[i].burst_time + "bursttt");
                            }
                        }

                        //storing the burst times in a dummy array
                        Robin[] tempRobin = new Robin[a.length];
                        int val[] = new int[a.length];
                        for (int i = 0; i < a.length; i++) {
                            tempRobin[i] = robin[i];
                            val[robin[i].p_id] = robin[i].burst_time;
                            System.out.println("tempRobin " + tempRobin[i].burst_time);
                        }

                        frameGantt.add(panel6);

                        int temp = 0;
                        int c = 0;
                        int count = 0;
                        int temp1 = robin[0].arrival_time;
                        int temp2 = 0;

                        //generating the labels for the round robin execution
                        while (count <= a.length) {
                            for (int i = 0; i < a.length; i++) {
                                if (quanta <= robin[i].burst_time && robin[i].arrival_time <= temp1) {
                                    temp = quanta;
                                } else if (robin[i].arrival_time < temp1) {
                                    temp = robin[i].burst_time;
                                    count++;
                                } else if (quanta <= robin[i].burst_time) {
                                    temp = quanta;
                                } else {
                                    temp = robin[i].burst_time;
                                    count++;
                                }
//                                if (robin[i].burst_time > 0 && robin[i].done == false) {
                                if (robin[i].burst_time > 0) {
                                    JLabel j = new JLabel("P " + (robin[i].p_id + 1) + " = " + temp);
                                    j.setBounds(c, 0, (int) (((double) temp / (double) sum) * 1000), 30);
                                    Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
                                    j.setBorder(border);
                                    j.setBackground(white);
                                    panel5.add(j);
                                    panel5.repaint();

                                    //label for the timeline
                                    JLabel k = new JLabel("" + temp2);
                                    k.setBounds(c, 0, (int) (((double) temp / (double) sum) * 1000), 18);
                                    Border border2 = BorderFactory.createLineBorder(Color.BLACK, 3);
                                    k.setBorder(border2);
                                    System.out.println("check check " + temp);
                                    k.setBackground(white);
                                    panel5_5.add(k);
                                    panel5_5.repaint();

                                    c += (((double) temp / (double) sum) * 1000);
                                    System.out.println(c + "c");
                                    temp1 = temp1 + temp;
                                    temp2 = temp2 + temp;
                                    System.out.println("temp1 is " + temp1);
                                    robin[i].burst_time = robin[i].burst_time - quanta;
                                    if (robin[i].burst_time <= 0) { //the given process is done executing 
                                        robin[i].done = true;
                                        robin[i].completion_time = temp1;
                                        robin[i].turn_around = robin[i].completion_time - robin[i].arrival_time;
                                        robin[i].wait_time = robin[i].turn_around - val[robin[i].p_id];
                                        System.out.println(robin[i].burst_time + "burst");
                                        System.out.println(robin[i].turn_around + "Turn around");
                                        System.out.println(robin[i].wait_time + "wait");
                                        count++;
                                    }
                                }
                            }
                        }

                        //generating the turn around times
                        //turn around time = completion time - arrival time
                        double avgtt = 0;
                        for (int i = 0; i < a.length; i++) {
                            JLabel j = new JLabel("Turn around P" + (robin[i].p_id + 1) + "=" + robin[i].turn_around);
                            avgtt = avgtt + robin[i].turn_around;
                            panel6_6.add(j);
                            panel6_6.repaint();
                        }
                        double num = avgtt / a.length; //average turn around time
                        DecimalFormat dec1 = new DecimalFormat("#0.00");
                        JLabel l = new JLabel("Average Turn_Around Time= " + (dec1.format(num)));

                        panel6_6.add(l);
                        panel6_6.repaint();

                        //generating the waiting time labels
                        //wait time = turm around time - burst time
                        double avgw = 0;
                        int value = 0;
                        for (int i = 0; i < a.length; i++) {
                            if (robin[i].wait_time < 0) {
                                value = 0;
                            } else {
                                value = robin[i].wait_time;
                            }
                            JLabel j = new JLabel("Waiting time P" + (robin[i].p_id + 1) + " = " + value);
                            avgw = avgw + robin[i].wait_time;
                            panel6_6.add(j);
                            panel6_6.repaint();
                        }
                        double no = avgw / a.length; //average wait time
                        DecimalFormat dec = new DecimalFormat("#0.00"); //setting precision to 2
                        JLabel j = new JLabel("Average Wait Time= " + (dec.format(no)));

                        panel6_6.add(j);
                        panel6_6.repaint();

                        //adding all the panels to the frame
                        frameGantt.add(panel5);
                        frameGantt.add(panel5_5);
                        frameGantt.add(panel6_6);
                        frameGantt.repaint();
                    }

                    //Preemptive SJF is checked
                    if (PreemptiveSJF.isSelected()) {
                        JLabel chartPreemptiveSJF = new JLabel("Preemptive SJF: "); //defining the label 
                        chartPreemptiveSJF.setFont(new Font("Ariel", Font.BOLD, 15));
                        panel10.add(chartPreemptiveSJF, (BorderLayout.WEST));

                        int[] a = new int[dropdown.getSelectedIndex() + 1];
                        int[] b = new int[dropdown.getSelectedIndex() + 1];

                        String[] sa = s1.split(",");
                        String[] sb = s2.split(",");
                        for (int i = 0; i < a.length; i++) {
                            a[i] = Integer.parseInt(sa[i]);
                            b[i] = Integer.parseInt(sb[i]);
                        }
                        SJF[] sjf = new SJF[a.length]; //store the data in an array of class SJF
                        SJF[] sjfBurst = new SJF[a.length];
                        int[] val = new int[a.length];
                        int sum = 0;
                        for (int i = 0; i < a.length; i++) {
                            sjf[i] = new SJF(i, a[i], b[i], false);
                            sjfBurst[i] = new SJF(i, a[i], b[i], false);
                            val[sjf[i].p_id] = sjf[i].burst_time;
                            sum = sum + a[i];
                        }
                        ShortestJoBFirst.findavgTime(sjf, sjf.length); //function call to calculate the wait and turn around times

                        //sorting the array based on arrival times
                        for (int i = 0; i < a.length; i++) {
                            SJF tempSJF = sjf[i];
                            SJF tempSJFBurst = sjfBurst[i];
                            for (int j = i + 1; j < a.length; j++) {
                                if (tempSJF.arrival_time > sjf[j].arrival_time) {
                                    sjf[i] = sjf[j];
                                    sjf[j] = tempSJF;
                                    tempSJF = sjf[i];
                                }
                            }
                            //sorting the array based on the burst times
                            for (int l = i + 1; l < a.length; l++) {
                                if (tempSJFBurst.burst_time > sjfBurst[l].burst_time) {
                                    sjfBurst[i] = sjfBurst[l];
                                    sjfBurst[l] = tempSJFBurst;
                                    tempSJFBurst = sjf[i];
                                }
                            }

                        }
                        frameGantt.add(panel10);
                        int temp = 0;
                        int c = 0;
                        int count = 0;
                        int tempnew = 0;

                        //generation of the labels for the process execution with the timelines below them
                        while (count < a.length) {
                            for (int i = 0; i < a.length; i++) {
                                if (sjf[i].burst_time > sjfBurst[i].burst_time && sjfBurst[i].arrival_time < sjf[i].burst_time && (sjfBurst[sjf[i].p_id].done == false)) {
                                    temp = sjfBurst[i].arrival_time;
                                    sjf[i].burst_time = sjf[i].burst_time - temp;
                                    sjfBurst[sjf[i].p_id].burst_time = sjfBurst[sjf[i].p_id].burst_time - temp;
                                } else {
                                    temp = sjf[i].burst_time;
                                    sjf[i].burst_time = sjf[i].burst_time - temp;
                                    sjfBurst[sjf[i].p_id].burst_time = sjfBurst[sjf[i].p_id].burst_time - temp;
                                }
                                if (temp != 0) {
                                    JLabel j = new JLabel("P " + (sjf[i].p_id + 1) + " = " + temp);
                                    j.setBounds(c, 0, (int) (((double) temp / (double) sum) * 1000), 30);
                                    Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
                                    j.setBorder(border);
                                    j.setBackground(white);
                                    panel9.add(j);

                                    JLabel k = new JLabel("" + tempnew);
                                    k.setBounds(c, 0, (int) (((double) temp / (double) sum) * 1000), 18);
                                    Border border2 = BorderFactory.createLineBorder(Color.BLACK, 3);
                                    k.setBorder(border2);
                                    k.setBackground(white);
                                    panel10_10.add(k);
                                    if (sjf[i].burst_time <= 0) {
                                        count++;
                                        sjf[i].done = true;
                                        sjfBurst[sjf[i].p_id].done = true;
                                    }
                                    c = c + (int) (((double) temp / (double) sum) * 1000);
                                    System.out.println(c + "c");
                                    tempnew = tempnew + temp;
                                }
                            }
                        }

                        //generating the turn around timme labels
                        double avgtt = 0;
                        for (int i = 0; i < a.length; i++) {
                            JLabel j = new JLabel("Turn around P" + (i + 1) + "=" + sjf[i].turn_around);
                            avgtt = avgtt + sjf[i].turn_around;
                            panel9_9.add(j);
                            panel9_9.repaint();
                        }
                        double num = avgtt / a.length; //average turn around time
                        DecimalFormat dec1 = new DecimalFormat("#0.00"); //precision set to 2
                        JLabel l = new JLabel("Average Turn_Around Time= " + (dec1.format(num)));

                        panel9_9.add(l);
                        panel9_9.repaint();

                        //generating the wait time labels
                        //wait time = turn around time  - arrival time
                        double avgw = 0;
                        int value = 0;
                        for (int i = 0; i < a.length; i++) {
                            sjf[i].wait_time = sjf[i].turn_around - val[sjf[i].p_id];
                            if (sjf[i].wait_time < 0) {
                                value = 0;
                            } else {
                                value = sjf[i].wait_time;
                            }
                            JLabel j = new JLabel("Waiting time P" + (i + 1) + " = " + value);
                            avgw = avgw + sjf[i].wait_time;
                            panel9_9.add(j);
                            panel9_9.repaint();
                        }
                        double no = avgw / a.length; //average wait time
                        DecimalFormat dec = new DecimalFormat("#0.00");
                        JLabel j = new JLabel("Average Wait Time= " + (dec.format(no)));

                        panel9_9.add(j);
                        panel9_9.repaint();

                        //adding all the panels to the frame
                        panel9.repaint();
                        frameGantt.add(panel9);
                        frameGantt.add(panel10_10);
                        frameGantt.add(panel9_9);
                        frameGantt.repaint();
                    }

                    //Preemptive Priority is selected
                    if (PreemptivePriority.isSelected()) {
                        JLabel chartPreemptivePriority = new JLabel("Preemptive Priority: "); //label for the selected scheduling
                        chartPreemptivePriority.setFont(new Font("Ariel", Font.BOLD, 15));
                        panel12.add(chartPreemptivePriority, (BorderLayout.WEST));

                        int[] a = new int[dropdown.getSelectedIndex() + 1];
                        int[] b = new int[dropdown.getSelectedIndex() + 1];
                        int[] c = new int[dropdown.getSelectedIndex() + 1];
                        String[] sa = s1.split(",");
                        String[] sb = s2.split(",");
                        String[] sc = s3.split(",");
                        for (int i = 0; i < a.length; i++) {
                            a[i] = Integer.parseInt(sa[i]); //burst times
                            b[i] = Integer.parseInt(sb[i]); //arrival times
                            c[i] = Integer.parseInt(sc[i]); //priorities
                        }
                        PriorityPreemptive[] priorityPreemptive = new PriorityPreemptive[a.length]; //class containing all the info for each process
                        PriorityPreemptive[] priority = new PriorityPreemptive[a.length]; //dummy array for the priorities
                        PriorityPreemptive[] burstTimes = new PriorityPreemptive[a.length]; //dummy array for the burst times

                        int sum = 0;
                        for (int i = 0; i < a.length; i++) {
                            priorityPreemptive[i] = new PriorityPreemptive(i, a[i], b[i], c[i], false);
                            priority[i] = new PriorityPreemptive(i, a[i], b[i], c[i], false);
                            sum = sum + a[i];
                        }
                        for (int i = 0; i < a.length; i++) {
                            burstTimes[i] = priorityPreemptive[i];
                        }

                        //sorting on the basis of arrival time
                        for (int i = 0; i < a.length; i++) {
                            PriorityPreemptive tempPriority = priorityPreemptive[i];
                            for (int j = i + 1; j < a.length; j++) {
                                if (tempPriority.arrival_time > priorityPreemptive[j].arrival_time) {
                                    priorityPreemptive[i] = priorityPreemptive[j];
                                    priorityPreemptive[j] = tempPriority;
                                    tempPriority = priorityPreemptive[i];
                                }
                            }
                            //sorting based on priorities
                            PriorityPreemptive temp = priority[i];
                            for (int j = i + 1; j < a.length; j++) {
                                if (temp.priority > priority[j].priority) {
                                    priority[i] = priority[j];
                                    priority[j] = temp;
                                    temp = priority[i];
                                }

                            }
                        }
                        frameGantt.add(panel12);
                        int temp = 0;
                        int k = 0;
                        int count = 0;
                        int temp1 = 0;

                        //generating labels for the processes and their respective timelines
                        while (count < a.length) {
                            for (int i = 0; i < a.length; i++) {
                                if (priorityPreemptive[i].priority > priority[i].priority && priority[i].arrival_time < priorityPreemptive[i].burst_time) {
                                    temp = priority[i].arrival_time;
                                    priorityPreemptive[i].burst_time = priorityPreemptive[i].burst_time - temp;
                                    priority[priorityPreemptive[i].p_id].burst_time = priority[priorityPreemptive[i].p_id].burst_time - temp;
                                } else {
                                    temp = priorityPreemptive[i].burst_time;
                                    priorityPreemptive[i].burst_time = priorityPreemptive[i].burst_time - temp;
                                    priority[priorityPreemptive[i].p_id].burst_time = priority[priorityPreemptive[i].p_id].burst_time - temp;
                                }
                                if (temp != 0) {
                                    JLabel j = new JLabel("P " + (priorityPreemptive[i].p_id + 1) + " = " + temp);
                                    j.setBounds(k, 0, (int) (((double) temp / (double) sum) * 1000), 30);
                                    Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
                                    j.setBorder(border);
                                    j.setBackground(white);
                                    panel11.add(j);
                                    panel11.repaint();

                                    JLabel l = new JLabel("" + temp1);
                                    l.setBounds(k, 0, (int) (((double) temp / (double) sum) * 1000), 18);
                                    l.setBorder(border);
                                    l.setBackground(white);
                                    panel11_11.add(l);
                                    panel11_11.repaint();

                                    temp1 = temp1 + temp;
                                    if (priorityPreemptive[i].burst_time <= 0) {
                                        count++;
                                        priorityPreemptive[i].done = true;
                                        priority[priorityPreemptive[i].p_id].done = true;
                                        priorityPreemptive[i].completion_time = temp1;
                                        priorityPreemptive[i].turn_around = priorityPreemptive[i].completion_time - priorityPreemptive[i].arrival_time;
                                        priorityPreemptive[i].wait_time = priorityPreemptive[i].turn_around - burstTimes[i].burst_time;
                                    }
                                    k = k + (int) (((double) temp / (double) sum) * 1000);
                                    System.out.println(k + "c");
                                }
                            }
                        }

                        //turn around time labels generated below
                        //turn around time = completion time - arrival time
                        double avgtt = 0;
                        for (int i = 0; i < a.length; i++) {
                            JLabel j = new JLabel("Turn around P" + (i + 1) + "=" + priorityPreemptive[i].turn_around);
                            avgtt = avgtt + priorityPreemptive[i].turn_around;
                            panel12_12.add(j);
                            panel12_12.repaint();
                        }
                        double num = avgtt / a.length; //average turn around time
                        DecimalFormat dec1 = new DecimalFormat("#0.00");
                        JLabel l = new JLabel("Average Turn_Around Time= " + (dec1.format(num)));

                        panel12_12.add(l);
                        panel12_12.repaint();

                        //turn wait time labels generated below
                        //wait time = turn around time - burst time
                        double avgw = 0;
                        for (int i = 0; i < a.length; i++) {
                            JLabel j = new JLabel("Waiting time P" + (i + 1) + " = " + priorityPreemptive[i].wait_time);
                            avgw = avgw + priorityPreemptive[i].wait_time;
                            panel12_12.add(j);
                            panel12_12.repaint();
                        }
                        double no = avgw / a.length; //average wait time
                        DecimalFormat dec = new DecimalFormat("#0.00"); //set precision 2
                        JLabel j = new JLabel("Average Wait Time= " + (dec.format(no)));

                        panel12_12.add(j);
                        panel12_12.repaint();

                        //adding all the above panels to the frame
                        frameGantt.add(panel11);
                        frameGantt.add(panel11_11);
                        frameGantt.add(panel12_12);
                        frameGantt.repaint();
                    }

                    frameGantt.repaint();
                    frameGantt.setVisible(true);
                }
            });
            //adding the components to the main frame
            frame.add(panel1);

            frame.add(panel2);

            frame.add(panel3);

            frame.add(panel4);

            frame.add(panel5);

            frame.add(panel6);

            frame.add(panel7);

            frame.add(panel8);

            frame.add(panel9);

            frame.setVisible(true);

        } catch (Exception e) {
            e = new Exception("Wrong Input");
        }
    }

    //class to hold the FCFS data 
    static class FCFS {

        public int p_id;
        public int burst_time, arrival_time, turn_around, wait_time, completion;
        public boolean done;

        public FCFS(int p_id, int burst_time, int arrival_time, boolean done) {
            this.p_id = p_id;
            this.burst_time = burst_time;
            this.arrival_time = arrival_time;
            this.done = done;
        }
    }

    //class to hold the non preemtive sjf data
    static class process {

        public int p_id;
        public int burst_time, arrival_time, completion_time, turn_around, wait_time;
        public boolean done;

        public process(int p_id, int burst_time, int arrival_time, boolean done) {
            this.p_id = p_id;
            System.out.println("pid" + this.p_id);
            this.burst_time = burst_time;
            System.out.println("burst time" + this.burst_time);
            this.arrival_time = arrival_time;
            System.out.println("arrival " + this.arrival_time);
            this.done = done;
            System.out.println("done " + this.done);
        }

    }

    //method to sort the sjf data based on burst and arrival times
    static int arrival(process[] p, int burst) {
        int minTime = 10000;
        int minBurst = 154546;
        int id = 0;
        int flag = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i].done == false) {
                if (p[i].arrival_time < minTime && p[i].burst_time < minBurst && p[i].arrival_time < burst) {
                    minTime = p[i].arrival_time;
                    minBurst = p[i].burst_time;
                    id = p[i].p_id;
                    flag = 1;
                } else if (p[i].arrival_time <= minTime && p[i].burst_time < minBurst) {
                    minTime = p[i].arrival_time;
                    minBurst = p[i].burst_time;
                    id = p[i].p_id;
                    flag = 1;
                } else if (flag == 0) {
                    minTime = p[i].arrival_time;
                    minBurst = p[i].burst_time;
                    id = p[i].p_id;
                    flag = 1;
                }
            }
        }
        return id;

    }

    //class to hold the preemptive sjf data
    static class SJF {

        public int p_id;
        public int burst_time, arrival_time, turn_around, wait_time;
        public boolean done;

        public SJF(int p_id, int burst_time, int arrival_time, boolean done) {
            this.p_id = p_id;
            this.burst_time = burst_time;
            this.arrival_time = arrival_time;
            this.done = done;
        }

    }

    //class to hold the preemptive priority data
    static class PriorityPreemptive {

        public int p_id;
        public int burst_time, arrival_time, priority, turn_around, wait_time, completion_time;
        public boolean done;

        public PriorityPreemptive(int p_id, int burst_time, int arrival_time, int priority, boolean done) {
            this.p_id = p_id;
            this.burst_time = burst_time;
            this.arrival_time = arrival_time;
            this.priority = priority;
            this.done = done;
        }

    }

    //class to hold Round robin data
    static class Robin {

        public int p_id;
        public int burst_time, arrival_time, priority, completion_time, wait_time, turn_around;
        public boolean done;

        public Robin(int p_id, int burst_time, int arrival_time, int priority, boolean done) {
            this.p_id = p_id;
            this.burst_time = burst_time;
            this.arrival_time = arrival_time;
            this.priority = priority;
            this.done = done;
        }
    }

    //class to hold the preemptive priority data
    static class processPriority {

        public int p_id;
        public int burst_time, arrival_time, priority, wait_time, turan_around, completion_time;
        public boolean done;

        public processPriority(int p_id, int burst_time, int arrival_time, int priority, boolean done) {
            this.p_id = p_id;
            System.out.println("pid" + this.p_id);
            this.burst_time = burst_time;
            System.out.println("burst time" + this.burst_time);
            this.arrival_time = arrival_time;
            System.out.println("arrival " + this.arrival_time);
            this.done = done;
            System.out.println("done " + this.done);
            this.priority = priority;
            System.out.println("priority " + this.priority);
        }
    }

    public static class ShortestJoBFirst {

        // Method to find the waiting time for SJF (preemptive)
        static void findWaitingTime(SJF proc[], int n, int wt[]) {
            int rt[] = new int[n];

            // Copy the burst time into rt[] 
            for (int i = 0; i < n; i++) {
                rt[i] = proc[i].burst_time;
            }

            int complete = 0, t = 0, minm = Integer.MAX_VALUE;
            int shortest = 0, finish_time;
            boolean check = false;

            // Process until all processes gets 
            // completed 
            while (complete != n) {

                for (int j = 0; j < n; j++) {
                    if ((proc[j].arrival_time <= t)
                            && (rt[j] < minm) && rt[j] > 0) {
                        minm = rt[j];
                        shortest = j;
                        check = true;
                    }
                }

                if (check == false) {
                    t++;
                    continue;
                }

                // Reduce remaining time by one 
                rt[shortest]--;

                // Update minimum 
                minm = rt[shortest];
                if (minm == 0) {
                    minm = Integer.MAX_VALUE;
                }

                // If a process gets completely 
                // executed 
                if (rt[shortest] == 0) {

                    // Increment complete 
                    complete++;
                    check = false;

                    // Find finish time of current 
                    // process 
                    finish_time = t + 1;

                    // Calculate waiting time 
                    wt[shortest] = finish_time
                            - proc[shortest].burst_time
                            - proc[shortest].arrival_time;
                    proc[shortest].wait_time = wt[shortest];

                    if (wt[shortest] < 0) {
                        wt[shortest] = 0;
                        proc[shortest].wait_time = wt[shortest];
                    }
                }
                // Increment time 
                t++;
            }
        }

        // Method to calculate turn around time 
        static void findTurnAroundTime(SJF proc[], int n,
                int wt[], int tat[]) {
            // calculating turnaround time by adding 
            // bt[i] + wt[i] 
            for (int i = 0; i < n; i++) {
                tat[i] = proc[i].burst_time + proc[i].wait_time;
                proc[i].turn_around = tat[i];
            }
        }

        // Method to calculate average time 
        public static void findavgTime(SJF proc[], int n) {
            int wt[] = new int[n], tat[] = new int[n];
            int total_wt = 0, total_tat = 0;

            // Function to find waiting time of all 
            // processes 
            findWaitingTime(proc, n, wt);

            // Function to find turn around time for 
            // all processes 
            findTurnAroundTime(proc, n, wt, tat);

            // Calculate total waiting time and total turnaround time 
            for (int i = 0; i < n; i++) {
                total_wt = total_wt + wt[i];
                total_tat = total_tat + tat[i];
                proc[i].wait_time = total_wt;
            }

            System.out.println("Average waiting time = "
                    + (float) total_wt / (float) n);
            System.out.println("Average turn around time = "
                    + (float) total_tat / (float) n);
        }
    }

    //method to sort priorities and arrival times 
    static int priorityCheck(processPriority[] p, int priority) {
        int minTime = 10000;
        int minPriority = 154546;
        int id = 0;
        int flag = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i].done == false) {
                if (p[i].arrival_time < minTime && p[i].priority < minPriority && p[i].priority < priority) {
                    minTime = p[i].arrival_time;
                    minPriority = p[i].priority;
                    id = p[i].p_id;
                    flag = 1;
                } else if (p[i].arrival_time <= minTime && p[i].priority < minPriority) {
                    minTime = p[i].arrival_time;
                    minPriority = p[i].priority;
                    id = p[i].p_id;
                    flag = 1;
                } else if (flag == 0) {
                    minTime = p[i].arrival_time;
                    minPriority = p[i].priority;
                    id = p[i].p_id;
                    flag = 1;
                }
            }
        }
        return id;

    }
}
