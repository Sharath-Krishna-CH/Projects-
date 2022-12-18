import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.*;

import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PrinterException;
import java.io.*;
import java.lang.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Main extends JFrame implements ActionListener
{

    JMenuBar mbar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu print= new JMenu("Print");
    JMenu review = new JMenu("Review");
    JMenu help = new JMenu("Help");

    boolean toggleBold = false;
    boolean toggleItalic = false;
    boolean toggleUnderline = false;
    boolean toggleStrike = false;
    JMenuItem newFile= new JMenuItem("New");
    JMenuItem openFile= new JMenuItem("Open");
    JMenuItem saveFile= new JMenuItem("Save");
    JMenuItem saveAsFile= new JMenuItem("Save as");
    JMenuItem exitFile= new JMenuItem("Exit");

    JMenuItem cut= new JMenuItem("Cut");
    JMenuItem copy= new JMenuItem("Copy");
    JMenuItem paste= new JMenuItem("Paste");
    JMenuItem selectAll= new JMenuItem("Select All");

    JMenuItem printFile= new JMenuItem("Print");

    JMenuItem upperCase = new JMenuItem("Upper Case");
    JMenuItem lowerCase = new JMenuItem("Lower Case");


    JMenuItem about= new JMenuItem("About");

    JTextPane textArea;
    JTextArea displayArea;

    JTextField findText;
    JLabel Find;
    JLabel Replace;
    JButton findButton;
    JTextField replaceText;
    JButton replaceButton;
    JButton replaceAllButton;

    JLabel sketchPad;
    JButton resizableRectangle;
    JButton circle;
    JButton oval;
    JButton line;
    JButton square;



    JScrollPane scrollPane;
    JLabel fontLabel;
    JSpinner fontSizeSpinner;
    JButton fontColorButton ;

    JComboBox fontBox;

    JButton bold;
    JButton italics;
    JButton underline;
    JButton strike;
    JButton rightAlign;
    JButton leftAlign;
    JButton centerAlign;


    protected class MyDocumentListener implements DocumentListener {
        final String newline = "\n";

        public void insertUpdate(DocumentEvent e) {
            updateLog(e, "inserted into");
        }
        public void removeUpdate(DocumentEvent e) {
            updateLog(e, "removed from");
        }
        public void changedUpdate(DocumentEvent e) {
            //Plain text components don't fire these events.
        }

        public void updateLog(DocumentEvent e, String action) {
            Document doc = (Document)e.getDocument();
            displayArea.append("Character count: " + doc.getLength() + newline);
            try{
                String text=doc.getText(0, doc.getLength());
                String words[]=text.split("\\s+");
                displayArea.append("Word count: " + words.length + newline);
            }
            catch (BadLocationException ex){
                ex.printStackTrace();
            }
            displayArea.setCaretPosition(displayArea.getDocument().getLength());
        }
    }

    Main()
    {
        textArea = new JTextPane();
        textArea.getDocument().addDocumentListener(new MyDocumentListener());
        textArea.setFont(new Font("Arial",Font.PLAIN,20));

        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(650,450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane displayScrollPane = new JScrollPane(displayArea);
        displayScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        displayScrollPane.setPreferredSize(new Dimension(200, 50));

        fontLabel = new JLabel("Font: ");
        bold = new JButton("B");
        Font fontBold = new Font("Ariel", Font.BOLD,15);
        bold.setFont(fontBold);
        italics = new JButton("I");
        Font fontItalics = new Font("Courier", Font.ITALIC,15);
        italics.setFont(fontItalics);
        underline = new JButton("U");
        strike = new JButton("S");
        findText = new JTextField(60);
        Find = new JLabel("Find   ");
        Replace = new JLabel("Replace");
        findButton = new JButton("Find");
        replaceText = new JTextField(60);
        replaceButton = new JButton("Replace");
        replaceAllButton = new JButton("Replace All");
        leftAlign = new JButton("L");
        centerAlign = new JButton("C");
        rightAlign = new JButton("R");
        sketchPad = new JLabel("                                       Sketch Pad                                        ");
        Font fontSketchPad = new Font("Calibre",Font.BOLD,25 );
        sketchPad.setFont(fontSketchPad);
        Font fontShapes = new Font("Calibre",Font.ITALIC,20 );
        resizableRectangle = new JButton("Rectangle");
        resizableRectangle.setFont(fontShapes);
        circle = new JButton("Circle");
        circle.setFont(fontShapes);
        oval = new JButton("Oval");
        oval.setFont(fontShapes);
        line = new JButton("Line");
        line.setFont(fontShapes);
        square = new JButton("Square");
        square.setFont(fontShapes);


        fontSizeSpinner = new JSpinner();
        fontSizeSpinner.setPreferredSize(new Dimension(50,25));
        fontSizeSpinner.setValue(20);
        fontSizeSpinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {

                textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int) fontSizeSpinner.getValue()));
            }

        });

        fontColorButton = new JButton("Color");
        fontColorButton.addActionListener(this);

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        fontBox = new JComboBox(fonts);
        fontBox.addActionListener(this);
        fontBox.setSelectedItem("Arial");




        //JPanel text = new JPanel(new GridLayout(3,1,0,2));
        JPanel text = new JPanel(new FlowLayout());
        text.setBackground(Color.LIGHT_GRAY);
        text.setVisible(true);

        JPanel textButtonBIUS = new JPanel(new FlowLayout());
        textButtonBIUS.setBackground(Color.LIGHT_GRAY);
        textButtonBIUS.setSize(100, 50);
        textButtonBIUS.setVisible(true);


        JPanel textButtonAlign = new JPanel(new FlowLayout());
        textButtonAlign.setBackground(Color.LIGHT_GRAY);
        textButtonAlign.setSize(100, 50);
        textButtonAlign.setVisible(true);

        JPanel textButtonFont = new JPanel(new FlowLayout());
        textButtonFont.setBackground(Color.LIGHT_GRAY);
        textButtonFont.setSize(100, 50);
        textButtonFont.setVisible(true);


        JPanel textButtons = new JPanel(new FlowLayout());
        textButtons.setBackground(Color.LIGHT_GRAY);
        textButtons.setVisible(true);

        JPanel textFind = new JPanel(new FlowLayout());
        textFind.setBackground(Color.LIGHT_GRAY);
        textFind.setVisible(true);

        JPanel textFindAlpha = new JPanel(new FlowLayout());
        textFindAlpha.setBackground(Color.LIGHT_GRAY);
        textFindAlpha.setVisible(true);

        JPanel textFindAlphaAlpha = new JPanel(new FlowLayout());
        textFindAlphaAlpha.setBackground(Color.LIGHT_GRAY);
        textFindAlphaAlpha.setVisible(true);

        JPanel textFindBeta = new JPanel(new FlowLayout());
        textFindBeta.setBackground(Color.LIGHT_GRAY);
        textFindBeta.setVisible(true);

        JPanel textFindBetaBeta = new JPanel(new FlowLayout());
        textFindBetaBeta.setBackground(Color.LIGHT_GRAY);
        textFindBetaBeta.setVisible(true);


        JPanel textFindGamma = new JPanel(new FlowLayout());
        textFindGamma.setBackground(Color.LIGHT_GRAY);
        textFindGamma.setVisible(true);

        JPanel textAlpha = new JPanel(new FlowLayout());
        textAlpha.setBackground(Color.LIGHT_GRAY);
        textAlpha.setVisible(true);

        JPanel textCount = new JPanel(new FlowLayout());
        textCount.setBackground(Color.LIGHT_GRAY);
        textCount.setVisible(true);

        JPanel shapes = new JPanel(new FlowLayout());
        shapes.setBackground(Color.LIGHT_GRAY);
        shapes.setVisible(true);

        JPanel shapesLabel= new JPanel(new FlowLayout());
        shapesLabel.setBackground(Color.LIGHT_GRAY);
        shapesLabel.setVisible(true);

        JPanel shapesButton1= new JPanel(new FlowLayout());
        shapesButton1.setBackground(Color.LIGHT_GRAY);
        shapesButton1.setVisible(true);


        JPanel p = new JPanel(new GridLayout(1,2,5,0));

        textButtonBIUS.add(bold,BorderLayout.WEST);
        textButtonBIUS.add(italics, BorderLayout.CENTER);
        textButtonBIUS.add(underline, BorderLayout.EAST);
        textButtonBIUS.add(strike,BorderLayout.CENTER);
        //textButtonBIUS.add(strike);

        textButtonAlign.add(rightAlign);
        textButtonAlign.add(leftAlign);
        textButtonAlign.add(centerAlign);

        textButtonFont.add(fontLabel);
        textButtonFont.add(fontSizeSpinner);
        textButtonFont.add(fontColorButton);
        textButtonFont.add(fontBox);

        textAlpha.add(scrollPane);

        textCount.add(displayScrollPane);


        textButtons.add(textButtonBIUS);
        textButtons.add(textButtonAlign);
        textButtons.add(textButtonFont);


        text.add(textButtons);
        text.add(textFind);


        textButtonFont.add(fontLabel);
        textButtonFont.add(fontSizeSpinner);
        textButtonFont.add(fontColorButton);
        textButtonFont.add(fontBox);

        textFindAlpha.add(Find);
        textFindAlphaAlpha.add(findText);
        textFindBeta.add(Replace);
        textFindBetaBeta.add(replaceText);
        textFindGamma.add(findButton);
        textFindGamma.add(replaceButton);
        textFindGamma.add(replaceAllButton);

        text.add(textFindAlpha);
        text.add(textFindAlphaAlpha);
        text.add(textFindBeta);
        text.add(textFindBetaBeta);
        text.add(textFindGamma);


        text.add(textAlpha);
        text.add(textCount);

        shapesLabel.add(sketchPad);
        shapesButton1.add(resizableRectangle);
        shapesButton1.add(circle);
        shapesButton1.add(square);
        shapesButton1.add(oval);
        shapesButton1.add(line);

        shapes.add(shapesLabel);
        shapes.add(shapesButton1);


        p.add(text);
        p.add(shapes);

        add(p);

        setJMenuBar(mbar);
        mbar.add(file);
        mbar.add(edit);
        mbar.add(print);
        mbar.add(review);
        mbar.add(help);

        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(saveAsFile);
        file.add(exitFile);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);

        print.add(printFile);

        review.add(upperCase);
        review.add(lowerCase);

        help.add(about);


        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        saveAsFile.addActionListener(this);
        printFile.addActionListener(this);
        exitFile.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);


        resizableRectangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ResizeRectangle rectangle = new ResizeRectangle();
                rectangle.main();
            }
        });
        circle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ResizeCircle Circle= new ResizeCircle();
                Circle.main();
            }
        });
        oval.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ResizeOval Oval= new ResizeOval();
                Oval.main();
            }
        });
        line.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ResizeLine Line= new ResizeLine();
                Line.main();
            }
        });
        square.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ResizeSquare Square = new ResizeSquare();
                Square.main();;
            }
        });
        bold.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                StyledDocument doc = (StyledDocument) textArea.getDocument();
                int selectionEnd = textArea.getSelectionEnd();
                int selectionStart = textArea.getSelectionStart();
                if (selectionStart == selectionEnd) {
                    return;
                }
                Element element = doc.getCharacterElement(selectionStart);
                AttributeSet as = element.getAttributes();

                MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
                StyleConstants.setBold(asNew, !StyleConstants.isBold(as));
                doc.setCharacterAttributes(selectionStart, textArea.getSelectedText()
                        .length(), asNew, true);

                textArea.setSelectionStart(selectionStart);
                textArea.setSelectionEnd(selectionEnd);
                textArea.getCaret().setSelectionVisible(true);
            }
        });
        italics.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                StyledDocument doc = (StyledDocument) textArea.getDocument();
                int selectionEnd = textArea.getSelectionEnd();
                int selectionStart = textArea.getSelectionStart();
                if (selectionStart == selectionEnd) {
                    return;
                }
                Element element = doc.getCharacterElement(selectionStart);
                AttributeSet as = element.getAttributes();

                MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
                StyleConstants.setItalic(asNew, !StyleConstants.isItalic(as));
                doc.setCharacterAttributes(selectionStart, textArea.getSelectedText()
                        .length(), asNew, true);

                textArea.setSelectionStart(selectionStart);
                textArea.setSelectionEnd(selectionEnd);
                textArea.getCaret().setSelectionVisible(true);
            }
        });
        underline.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                StyledDocument doc = (StyledDocument) textArea.getDocument();
                int selectionEnd = textArea.getSelectionEnd();
                int selectionStart = textArea.getSelectionStart();
                if (selectionStart == selectionEnd) {
                    return;
                }
                Element element = doc.getCharacterElement(selectionStart);
                AttributeSet as = element.getAttributes();

                MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
                StyleConstants.setUnderline(asNew, !StyleConstants.isUnderline(as));
                doc.setCharacterAttributes(selectionStart, textArea.getSelectedText()
                        .length(), asNew, true);

                textArea.setSelectionStart(selectionStart);
                textArea.setSelectionEnd(selectionEnd);
                textArea.getCaret().setSelectionVisible(true);
            }
        });
        strike.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Style style = textArea.getStyle(StyleContext.DEFAULT_STYLE);
                StyleConstants.setStrikeThrough(style,toggleStrike);
                toggleStrike=!toggleStrike;
            }
        });
        rightAlign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Style style = textArea.getStyle(StyleContext.DEFAULT_STYLE);
                StyleConstants.setAlignment(style, StyleConstants.ALIGN_RIGHT);
            }
        });
        leftAlign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Style style = textArea.getStyle(StyleContext.DEFAULT_STYLE);
                StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT);
            }
        });
        centerAlign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Style style = textArea.getStyle(StyleContext.DEFAULT_STYLE);
                StyleConstants.setAlignment(style, StyleConstants.ALIGN_CENTER);
            }
        });
        upperCase.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean upperCaseFlag = false;
                int startPosition = 0;
                int endPosition = 0;
                try {
                    if ((textArea.getSelectionStart()!=textArea.getSelectionEnd() && !upperCaseFlag)) {
                        startPosition = textArea.getSelectionStart();
                        endPosition = textArea.getSelectionEnd();
                        textArea.replaceSelection(textArea.getSelectedText().toUpperCase());
                        textArea.setSelectionStart(startPosition);
                        textArea.setSelectionEnd(endPosition);
                        textArea.getCaret().setSelectionVisible(true);
                        upperCaseFlag = true;
                    }
                    textArea.requestFocus();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        });
        lowerCase.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean lowerCaseFlag = false;
                int startPosition = 0;
                int endPosition = 0;
                try {
                    if ((textArea.getSelectionStart()!=textArea.getSelectionEnd() && !lowerCaseFlag)) {
                        startPosition = textArea.getSelectionStart();
                        endPosition = textArea.getSelectionEnd();
                        textArea.replaceSelection(textArea.getSelectedText().toLowerCase());
                        textArea.setSelectionStart(startPosition);
                        textArea.setSelectionEnd(endPosition);
                        textArea.getCaret().setSelectionVisible(true);
                        lowerCaseFlag = true;
                    }
                    textArea.requestFocus();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        });
        findButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String searchWord=findText.getText();
                Highlighter.HighlightPainter painter =
                        new DefaultHighlighter.DefaultHighlightPainter( Color.cyan );
                String text=textArea.getText();
                int offset = text.indexOf(searchWord);
                int length = searchWord.length();

                while ( offset != -1)
                {
                    try
                    {
                        textArea.getHighlighter().addHighlight(offset, offset + length, painter);
                        offset = text.indexOf(searchWord, offset+1);
                    }
                    catch(BadLocationException ble) { System.out.println(ble); }
                }
            }
        });
        replaceButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String from=findText.getText();
                int start = textArea.getText().indexOf(from);
                //if (start >= 0 && from.length() > 0)
                //textArea.replaceRange(replaceText.getText(), start, start + from.length());
                Document doc = textArea.getDocument();

                try {
                    for (int pos = 0; pos < doc.getLength() - from.length(); pos++) {

                        String text = doc.getText(pos, from.length());
                        if (from.equals(text)) {
                            doc.remove(pos, from.length());
                            doc.insertString(pos, replaceText.getText(), null);
                            break;
                        }

                    }
                } catch (BadLocationException exp) {
                    exp.printStackTrace();
                }
            }
        });
        replaceAllButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String from=findText.getText();
                Document doc = textArea.getDocument();

                try {
                    for (int pos = 0; pos < doc.getLength() - from.length(); pos++) {

                        String text = doc.getText(pos, from.length());
                        if (from.equals(text)) {
                            doc.remove(pos, from.length());
                            doc.insertString(pos, replaceText.getText(), null);
                        }

                    }
                } catch (BadLocationException exp) {
                    exp.printStackTrace();
                }
            }
        });


        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
        exitFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
        setJMenuBar(mbar);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("New")){
            textArea.setText(null);

        }else if(e.getSource()==fontColorButton) {
            JColorChooser colorChooser = new JColorChooser();

            Color color = colorChooser.showDialog(null, "Choose a color", Color.black);

            textArea.setForeground(color);
        }else if(e.getSource()==fontBox) {
            String firstSelectedChar;
            String text = textArea.getText();
            int selectionStart = textArea.getSelectionStart();
            int selectionEnd = textArea.getSelectionEnd();
            firstSelectedChar = text.substring(selectionStart, selectionEnd);
            textArea.setFont(new Font((String)fontBox.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
        }else if (e.getActionCommand().equalsIgnoreCase("Open")) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Text Files", "txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);

            int action=fileChooser.showOpenDialog (null);

            if (action!=JFileChooser.APPROVE_OPTION) {
                return;
            } else {
                try{
                    BufferedReader reader=new BufferedReader (new FileReader(fileChooser.getSelectedFile()));
                    textArea.read(reader, e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }


        } else if (e.getActionCommand().equalsIgnoreCase("Save")) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Text Files", "txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);

            int action = fileChooser.showSaveDialog(null);
            if(action != JFileChooser.APPROVE_OPTION){
                return;
            }else {
                String fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
                if(!fileName.contains(".txt"))
                    fileName = fileName+".txt";
                try{
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    textArea.write(writer);
                }catch(IOException exception){
                    exception.printStackTrace();
                }
            }

        } else if (e.getActionCommand().equalsIgnoreCase("Save As")) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(true);

            int action = fileChooser.showSaveDialog(null);
            if(action != JFileChooser.APPROVE_OPTION){
                return;
            }else {
                String fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
                try{
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    textArea.write(writer);
                }catch(IOException exception){
                    exception.printStackTrace();
                }
            }
        } else if (e.getActionCommand().equalsIgnoreCase("Print")) {
            try{
                textArea.print();
            } catch(PrinterException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null , ex);
            }

        } else if (e.getActionCommand().equalsIgnoreCase("Exit")) {
            System.exit(0);
        } else if (e.getActionCommand().equalsIgnoreCase("Cut")) {
            textArea.cut();
        } else if (e.getActionCommand().equalsIgnoreCase("Copy")) {
            textArea.copy();
        } else if (e.getActionCommand().equalsIgnoreCase("Paste")) {
            textArea.paste();
        } else if (e.getActionCommand().equalsIgnoreCase("Select All")) {
            textArea.selectAll();
        } else if (e.getActionCommand().equalsIgnoreCase("About")) {
            JOptionPane.showMessageDialog(null,"Created by Sharath Krishna", "About",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String args[])
    {
        Main x = new Main();

        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setTitle("Text Editor");
        x.setSize(1500, 850);
        x.setResizable(false);
        x.setLocationRelativeTo(null);
        x.setVisible(true);
    }

}

class ResizeRectangle extends JPanel {
    private int SIZE = 8;
    private Rectangle2D[] points = { new Rectangle2D.Double(50, 50,SIZE, SIZE), new Rectangle2D.Double(150, 100,SIZE, SIZE) };
    Rectangle2D s = new Rectangle2D.Double();
    ShapeResizeHandler ada = new ShapeResizeHandler();

    public ResizeRectangle() {
        addMouseListener(ada);
        addMouseMotionListener(ada);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < points.length; i++) {
            g2.fill(points[i]);
        }
        s.setRect(points[0].getCenterX(), points[0].getCenterY(),
                Math.abs(points[1].getCenterX()-points[0].getCenterX()),
                Math.abs(points[1].getCenterY()- points[0].getCenterY()));

        g2.draw(s);
    }

    class ShapeResizeHandler extends MouseAdapter {
        Rectangle2D r = new Rectangle2D.Double(0,0,SIZE,SIZE);
        private int pos = -1;
        public void mousePressed(MouseEvent event) {
            Point p = event.getPoint();

            for (int i = 0; i < points.length; i++) {
                if (points[i].contains(p)) {
                    pos = i;
                    return;
                }
            }
        }

        public void mouseReleased(MouseEvent event) {
            pos = -1;
        }

        public void mouseDragged(MouseEvent event) {
            if (pos == -1)
                return;
            points[pos].setRect(event.getPoint().x,event.getPoint().y,points[pos].getWidth(),
                    points[pos].getHeight());
            repaint();
        }
    }

    public void main() {

        JFrame f = new JFrame("Resize Rectangle");
        f.add(new ResizeRectangle());
        f.setSize(650, 600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}


class ResizeCircle extends JPanel {
    public void main() {
        JFrame f = new JFrame();
        BallCreation c = new BallCreation();
        f.add(c);
        f.setSize(500, 500);
        f.setVisible(true);
    }
}
class BallCreation extends JPanel{
    private static final long serialVersionUID = 1L;
    private int height = 20;
    private int width = 20;
    private JPanel panel;
    private JButton button1;
    private  JButton button2;

    public BallCreation(){
        panel = new JPanel();

        button1 = new JButton("Increase Size");
        button2 = new JButton("Decrease Size");
        add(button1);
        add(button2);

        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                height = height + 10;
                width = width + 10;
                repaint();
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                height=height-10;
                width = width-10;
                repaint();
            }
        });

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.setColor(Color.GRAY);
        g.fillOval(20, 20, width, height);
    }
}
class ResizeOval extends JPanel {
    public void main() {
        JFrame f = new JFrame();
        BallCreation1 c = new BallCreation1();
        f.add(c);
        f.setSize(500, 500);
        f.setVisible(true);
    }
}

class BallCreation1 extends JPanel{
    private static final long serialVersionUID = 1L;
    private int height = 20;
    private int width = 20;
    private int x = 15;
    private  int y = 15;
    private JPanel panel;
    private JButton button1;
    private  JButton button2;
    private  JButton button3;
    private  JButton button4;

    public BallCreation1(){
        panel = new JPanel();

        button1 = new JButton("Increase Size");
        button2 = new JButton("Decrease Size");
        button3 = new JButton("Increase Size");
        button4 = new JButton("Decrease Size");
        add(button1);
        add(button2);
        add(button3);
        add(button4);


        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                height = height + 10;
                width = width + 10;
                repaint();
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                height=height-7;
                width = width-7;
                repaint();
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                x=x+7;
                y= y+7;
                repaint();
            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                x=x-7;
                y= y-7;
                repaint();
            }
        });

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.setColor(Color.GRAY);
        g.fillOval(x, y, width, height);
    }
}
class ResizeLine extends JPanel {
    private int SIZE = 8;
    private Rectangle2D[] points = { new Rectangle2D.Double(50, 50,SIZE, SIZE), new Rectangle2D.Double(150, 50,SIZE, SIZE) };
    Rectangle2D s = new Rectangle2D.Double();
    ShapeResizeHandler ada = new ShapeResizeHandler();

    public ResizeLine() {
        addMouseListener(ada);
        addMouseMotionListener(ada);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < points.length; i++) {
            g2.fill(points[i]);
        }
        s.setRect(points[0].getCenterX(), 50,
                Math.abs(points[1].getCenterX()-points[0].getCenterX()),
                1);

        g2.draw(s);
    }

    class ShapeResizeHandler extends MouseAdapter {
        Rectangle2D r = new Rectangle2D.Double(10,10,SIZE,SIZE);
        private int pos = -1;
        public void mousePressed(MouseEvent event) {
            Point p = event.getPoint();

            for (int i = 0; i < points.length; i++) {
                if (points[i].contains(p)) {
                    pos = i;
                    return;
                }
            }
        }

        public void mouseReleased(MouseEvent event) {
            pos = -1;
        }

        public void mouseDragged(MouseEvent event) {
            if (pos == -1)
                return;
            points[pos].setRect(event.getPoint().x,event.getPoint().y,points[pos].getWidth(),
                    points[pos].getHeight());
            repaint();
        }
    }

    public void main() {

        JFrame f = new JFrame("Resize Rectangle");
        f.add(new ResizeLine());
        f.setSize(650, 600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
class ResizeSquare extends JPanel {
    private int SIZE = 8;
    private Rectangle2D[] points = { new Rectangle2D.Double(50, 50,SIZE, SIZE), new Rectangle2D.Double(150, 150,SIZE, SIZE) };
    Rectangle2D s = new Rectangle2D.Double();
    ShapeResizeHandler ada = new ShapeResizeHandler();

    public ResizeSquare() {
        addMouseListener(ada);
        addMouseMotionListener(ada);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < points.length; i++) {
            g2.fill(points[i]);
        }
        s.setRect(points[0].getCenterX(), points[0].getCenterY(),
                Math.abs(points[1].getCenterX()-points[0].getCenterX()),
                Math.abs(points[1].getCenterX()- points[0].getCenterX()));

        g2.draw(s);
    }

    class ShapeResizeHandler extends MouseAdapter {
        Rectangle2D r = new Rectangle2D.Double(0,0,SIZE,SIZE);
        private int pos = -1;
        public void mousePressed(MouseEvent event) {
            Point p = event.getPoint();

            for (int i = 0; i < points.length; i++) {
                if (points[i].contains(p)) {
                    pos = i;
                    return;
                }
            }
        }

        public void mouseReleased(MouseEvent event) {
            pos = -1;
        }

        public void mouseDragged(MouseEvent event) {
            if (pos == -1)
                return;
            points[pos].setRect(event.getPoint().x,event.getPoint().y,points[pos].getWidth(),
                    points[pos].getHeight());
            repaint();
        }
    }

    public void main() {

        JFrame f = new JFrame("Resize Square");
        f.add(new ResizeSquare());
        f.setSize(650, 600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
