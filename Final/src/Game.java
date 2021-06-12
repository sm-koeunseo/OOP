import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
 
public class Game extends Frame {
   StartFrame f;
    
    private int FRAME_WIDTH = 800;
    private int FRAME_HEIGHT = 600;
     
    private int SCREEN_WIDTH;
    private int SCREEN_HEIGHT;
     
    int speed = 700; // 단어가 떨어지는 속도
    int interval = 2 * 1000; // 새로운 단어가 나오는 간격
     
    int score = 0;
    int life = 3;
    int curLevel = 0;
    private int MAX_LEVEL;
     
    boolean isPlaying = false;
     
    WordGenerator wg = null; // 단어를 생성하는 쓰레드
    WordDropper wm = null; // 단어를 떨어뜨리는 쓰레드
     
    FontMetrics fm; // 화면에서의 글자 길이를 구하는데 사용
    ThreadGroup virusGrp = new ThreadGroup("virus"); // 바이러스 쓰레드들의 그룹
     
    String[][] data = { 
            { "java", "swing", "import", "println", "Vector", "Thread","GridLayout", "int", "repaint", "boolean", "private", "event"},
            { "java", "swing", "import", "println", "Vector", "Thread","GridLayout", "int", "repaint", "boolean", "private", "event"},
            { "javax", "util", "new", "Panel", "Label", "String", "BorderLayout", "float", "this", "true", "North", "color"},
            { "javax", "util", "new", "Panel", "Label", "String", "BorderLayout", "float", "this", "true", "North", "color" }
        };
  
    final Level[] LEVEL = { new Level(500, 2000, 1000, data[0]), 
                            new Level(250, 1500, 2000, data[1]),
                            new Level(120, 1000, 3000, data[2]), 
                            new Level(100, 500, 4000, data[3]), };
     
    Vector words = new Vector();
    TextField tf = new TextField();
    Panel panel_level = new Panel();
    Panel panel_score = new Panel();
    Panel panel_life = new Panel();
    JButton btn_game = new JButton();
    JButton user = new JButton();
    JButton professor = new JButton();
    Label lbLevel = new Label("Level:" + curLevel, Label.CENTER);
    Label lbScore = new Label("Score:" + score, Label.CENTER);
    Label lbLife = new Label("Life:" + life, Label.CENTER);
    MyCanvas screen = new MyCanvas();
     
    Game(StartFrame f, Point p) {
        this("Game");
        this.f = f;
        setLocation(p);
    }
     
    Game(String title) {
        super(title);
        
        btn_game.setBorderPainted(false);
        btn_game.setContentAreaFilled(false);
 
        
        lbLevel.setFont(new Font("ELAND 나이스", Font.BOLD, 20));
        lbScore.setFont(new Font("ELAND 나이스", Font.BOLD, 20));
        lbLife.setFont(new Font("ELAND 나이스", Font.BOLD, 20));
        
        panel_level.setBackground(Color.white);
        panel_level.add(lbLevel);
        
        panel_score.setBackground(Color.white);
        panel_score.add(lbScore);
        
        panel_life.setBackground(Color.white);
        panel_life.add(lbLife);

        screen.setBackground(Color.white);
        
        
        panel_level.setBounds(20, 40, 170, 40);
        panel_score.setBounds(206, 40, 170, 40);
        panel_life.setBounds(392, 40, 170, 40);

        btn_game.setBounds(580, 90, 180, 50);
        btn_game.setBorderPainted(false);
        btn_game.setContentAreaFilled(false);
        ImageIcon btn_g = new ImageIcon("Final/images/btn_game.png");
        ImageIcon user_smile = new ImageIcon("Final/images/game_student.png");
        ImageIcon professor_smile = new ImageIcon("Final/images/game_smile.png");
        
        
        
        btn_game.setIcon(btn_g);
        btn_game.setBorderPainted(false);
        btn_game.setContentAreaFilled(false);
        btn_game.setFocusPainted(false);
      
        
        user.setBackground(Color.white);
        user.setBounds(580, 150, 180, 190);
        user.setIcon(user_smile);
        user.setBorderPainted(false);
        user.setContentAreaFilled(false);
        user.setFocusPainted(false);
     
        
        professor.setBackground(Color.white);
        professor.setBounds(580, 350, 180, 190);
        professor.setIcon(professor_smile);
        professor.setBorderPainted(false);
        professor.setContentAreaFilled(false);
        professor.setFocusPainted(false);
        
        add(tf);
        tf.setBounds(20,550,540,20);
      
        add(btn_game);
        add(user);
        add(professor);
        add(panel_level);
        add(panel_score);
        add(panel_life);
        add(screen, "Center");
     
        
        add(new MyCanvas());
     
        MyEventHandler handler = new MyEventHandler();
        addWindowListener(handler);
        tf.addActionListener(handler);
     
        setBounds(500, 200, FRAME_WIDTH, FRAME_HEIGHT); 
        setResizable(false); // 크기조절 불가능
      
        setVisible(true); // 프레임을 보여줌
     
        SCREEN_WIDTH = screen.getWidth();
        SCREEN_HEIGHT = screen.getHeight();
        MAX_LEVEL = LEVEL.length - 1; 
     
        fm = getFontMetrics(getFont());
    }
     
    public void repaint() {
        super.repaint();
        screen.repaint();
    }
     
    public void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
        }
    }
     
    // 게임이 시작됨
    public void start() {
        showLevel(0); // Level을 정의하고 title에 출력
        isPlaying = true;
     
        wg = new WordGenerator();
        wg.start();
     
        wm = new WordDropper();
        wm.start();
    }
     
    public Level getLevel(int level) {
        if (level > MAX_LEVEL)
            level = MAX_LEVEL;
        if (level < 0)
            level = 0;
     
        return LEVEL[level];
    }
     
    public boolean levelUpCheck() {
        Level lvl = getLevel(curLevel);
     
        return score >= lvl.levelUpScore;
    }
     
    public synchronized int getCurLevel() { //쓰레드 간의 동기화를 위해 synchronize 사용
        return curLevel;
    }
     
    public synchronized void levelUp() {
        virusGrp.interrupt();
     
        Level lvl = getLevel(++curLevel);
     
        lbLevel.setText("Level:" + curLevel);
        words.clear();
        screen.clear();
        showLevel(curLevel);
     
        speed = lvl.speed;
        interval = lvl.interval;
    }
     
    // Level을 표시
    public void showLevel(int level) {
        String tmp = "Level " + level;
        showTitle(tmp, 1 * 1000); // 출력되는 title의 정보
    }
     
    // 출력되는 title의 정보
    public void showTitle(String title, int time) {
        Graphics g = screen.getGraphics();
     
        Font titleFont = new Font("Serif", Font.BOLD, 20);
        g.setFont(titleFont);
     
        FontMetrics fm = getFontMetrics(titleFont);
        int width = fm.stringWidth(title);
     
        g.drawString(title, (SCREEN_WIDTH - width) / 2, SCREEN_HEIGHT / 2);
        delay(time);
    }
     
    
    class WordDropper extends Thread {
       
        public void run() {
            outer: while (isPlaying) { // life가 0이하가 되면 break outer;됨
                delay(speed);
                for (int i = 0; i < words.size(); i++) {
                    Word tmp = (Word) words.get(i);
     
                    tmp.y += tmp.step;
     
                    // 화면 최하단에 도달했을때
                    // 단어는 remove되고
                    // Life가 감소한다
                    if (tmp.y >= SCREEN_HEIGHT) {
                        tmp.y = SCREEN_HEIGHT;
                        words.remove(tmp);
                        life--;
                        lbLife.setText("Life:" + life);
                        break;
                    }
     
                    // life가 0 이하가 되면 
                    // while문을 빠져 나감
                    if (life <= 0) {
                        isPlaying = false;
                        showTitle("Game Over", 0);
                        try {
                     Thread.sleep(3000);
                  } catch (InterruptedException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                  }
                        f.setVisible(true);
                        setVisible(false);
     
                        break outer;
                    }
                } 
     
                repaint(); // AWT안에 구현되어 있기 때문에 Frame을 상속받으면 바로 사용 가능
                           // update()메소드를 자동호출
            }
        } 
    }
    
    class WordGenerator extends Thread {
        public void run() {
            while (isPlaying) {
                String[] data = LEVEL[getCurLevel()].data; 
                
                int rand = (int) (Math.random() * data.length);
                
                // 약 10번에 한번 꼴로 바이러스를 생성한다.
                boolean isVirus = ((int) (Math.random() * 10) + 1) / 10 != 0;
     
                Word word = new Word(data[rand], isVirus);
                words.add(word); 
                delay(interval);
            }
        } // end of run()
    }
    
    class Word {
        String word = "";
        int x = 0;
        int y = 0;
        int step = 5;
     
        Color color = Color.BLACK;
        boolean isVirus = false;
     
        Word(String word) {
            this(word, 10, false);
        }
     
        Word(String word, boolean isVirus) {
            this(word, 10, isVirus);
        }
     
        Word(String word, int step, boolean isVirus) {
            this.word = word;
            this.step = step;
            this.isVirus = isVirus;
     
       
               
     
            int strWidth = fm.stringWidth(word);
     
            x = (int) (Math.random() * SCREEN_WIDTH);
     
            if (x + strWidth >= SCREEN_WIDTH)
                x = SCREEN_WIDTH - strWidth;
        }
     
        public String toString() {
            return word;
        }
    }
    
    class VirusThread extends Thread {
        public VirusThread(ThreadGroup group, String name) {
            super(group, name);
        }
     
        public void run() {
            int rand = (int) (Math.random() * 5);
     
            int virusTime = 10 * 1000; // 바이러스 동작시간을 10초로 설정한다.
     
            switch (rand) {
            case 0:
                speed = speed / 2;
                break;
            case 1:
                interval = interval / 2;
                break;
            case 2:
                speed = speed * 2;
                break;
            case 3:
                interval = interval * 2;
                break;
            case 4:
                words.clear();
                break;
            }
     
            delay(virusTime);
     
            int curLevel = getCurLevel();
            speed = LEVEL[curLevel].speed;
            interval = LEVEL[curLevel].interval;
        }
    }
    
    class MyCanvas extends Canvas {
       public MyCanvas() {
         
          
         setBackground(new Color(239, 239, 143));
         setSize(540, 450);
         setLocation(20, 90);
      }
      
        public void clear() {
            Graphics g = getGraphics();
            g.clearRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        }
     
        public void paint(Graphics g) {
            clear();
     
            for (int i = 0; i < words.size(); i++) {
                Word tmp = (Word) words.get(i);
                g.setColor(tmp.color);
             
                g.setFont(new Font("ELAND 나이스", Font.BOLD, 20));
                g.drawString(tmp.word, tmp.x, tmp.y);
            }
        }
    }
    
    class Level {
        int speed;
        int interval;
        int levelUpScore;
        String[] data;
     
        Level(int speed, int interval, int levelUpScore, String[] data) {
            this.speed = speed;
            this.interval = interval;
            this.levelUpScore = levelUpScore;
            this.data = data;
        }
    } 
    
    class MyEventHandler extends WindowAdapter implements ActionListener {
       
        public void actionPerformed(ActionEvent ae) {
            String input = tf.getText().trim(); // 문자열의 앞뒤 공백 제거
            tf.setText("");
     
            System.out.println(input);
     
            if (!isPlaying)
                return;
     
            
            for (int i = 0; i < words.size(); i++) {
                
                Word tmp = (Word) words.get(i);
     
                 
                if (input.equals(tmp.word)) { 
                   repaint();
                    user.setBackground(Color.white);
                    user.setBounds(580, 150, 180, 190);
                    ImageIcon user_sad = new ImageIcon("Final/images/game_student.png");

                    user.setIcon(user_sad);
                    user.setBorderPainted(false);
                    user.setContentAreaFilled(false);
                    user.setFocusPainted(false);
                    repaint();
                    professor.setBackground(Color.white);
                    professor.setBounds(580, 350, 180, 190);
                    ImageIcon professor_sad = new ImageIcon("Final/images/game_smile.png");

                    professor.setIcon(professor_sad);
                    professor.setBorderPainted(false);
                    professor.setContentAreaFilled(false);
                    professor.setFocusPainted(false);
                    
                    
                    
                    words.remove(i);
               
                    score += 10; // 단어 당 10점씩 획득
                    lbScore.setText("Score:" + score); // Score가 갱신됨
                    Toolkit.getDefaultToolkit().beep(); 
                    
     
                    if (curLevel != MAX_LEVEL && levelUpCheck()) {
                        levelUp();
                    } else {
                        if (tmp.isVirus) {
                            new VirusThread(virusGrp, "virus").start(); 
                        }
                    }
     
                    break;
                }
                else {
                   repaint();
                    user.setBackground(Color.white);
                    user.setBounds(580, 150, 180, 190);
                    ImageIcon user_sad = new ImageIcon("Final/images/game_cry.png");

                    user.setIcon(user_sad);
                    user.setBorderPainted(false);
                    user.setContentAreaFilled(false);
                    user.setFocusPainted(false);
                 
                    professor.setBackground(Color.white);
                    professor.setBounds(580, 350, 180, 190);
                    ImageIcon professor_sad = new ImageIcon("Final/images/game_angry.png");

                    professor.setIcon(professor_sad);
                    professor.setBorderPainted(false);
                    professor.setContentAreaFilled(false);
                    professor.setFocusPainted(false);
                }
                
            } 
     
            repaint(); 
        }
     
        public void windowClosing(WindowEvent e) {

           this.windowClosed(e);
            e.getWindow().setVisible(false);
            e.getWindow().dispose();
           f.setVisible(true);
        }
    } 
}