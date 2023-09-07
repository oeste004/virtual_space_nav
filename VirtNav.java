import java.awt.Color;
import javax.swing.*;
import java.util.Random;

public class VirtNav
{
    public static void main(String[] args)
    {
        new VirtNav();
    }

    public void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) { }
    }
    
    public VirtNav()
    {

        GeometricObject[] sArray = new GeometricObject[14];
        
        Point p1 = new Point(113,332);
        Point p2 = new Point(123,352);
       
        Rectangle rec1 = new Rectangle(p1,p2); //watchman

        rec1.setBoundaryColor(Color.red);

        sArray[0] = rec1;
        
        p1 = new Point(226, 341);
        p2 = new Point(412, 341);
        Point p3 = new Point(396, 373);
        Point p4 = new Point(333, 373);
        Point p5 = new Point(333, 382);
        Point p6 = new Point(297, 382);
        Point p7 = new Point(297, 373);
        Point p8 = new Point(255, 373);
        Point p9 = new Point(255, 458);
        Point p10 = new Point(297, 458);
        Point p11 = new Point(297, 454);
        Point p12 = new Point(333, 454);
        Point p13 = new Point(333, 458);
        Point p14 = new Point(398, 458);
        Point p15 = new Point(379, 492);
        Point p16 = new Point(226, 492);
        
        SimplePolygon poly2 = new SimplePolygon(); //Kitchen top
        poly2.addVertex(p1);
        poly2.addVertex(p2);
        poly2.addVertex(p3);
        poly2.addVertex(p4);
        poly2.addVertex(p5);
        poly2.addVertex(p6);
        poly2.addVertex(p7);
        poly2.addVertex(p8);
        poly2.addVertex(p9);
        poly2.addVertex(p10);
        poly2.addVertex(p11);
        poly2.addVertex(p12);
        poly2.addVertex(p13);
        poly2.addVertex(p14);
        poly2.addVertex(p15);
        poly2.addVertex(p16);

        //poly2.setBoundaryColor(Color.red);

        sArray[1] = poly2;

        p1 = new Point(202, 26);
        p2 = new Point(311, 26);
        p3 = new Point(311, 161);
        p4 = new Point(202, 161);

        SimplePolygon poly3 = new SimplePolygon(); //Bed in room # 1
        poly3.addVertex(p1);
        poly3.addVertex(p2);
        poly3.addVertex(p3);
        poly3.addVertex(p4);

        //poly3.setBoundaryColor(Color.red);

        sArray[2] = poly3;
        
        p1 = new Point(118, 66);
        p2 = new Point(65, 169);
        p3 = new Point(88, 185);
        p4 = new Point(141, 79);
        
        SimplePolygon poly4 = new SimplePolygon(); //Left dresser room # 1
        poly4.addVertex(p1);
        poly4.addVertex(p2);
        poly4.addVertex(p3);
        poly4.addVertex(p4);
        
        //poly4.setBoundaryColor(Color.red);

        sArray[3] = poly4;

        p1 = new Point(394, 65);
        p2 = new Point(372, 81);
        p3 = new Point(425, 187);
        p4 = new Point(449, 172);
        
        SimplePolygon poly5 = new SimplePolygon(); //Right dresser room # 1
        poly5.addVertex(p1);
        poly5.addVertex(p2);
        poly5.addVertex(p3);
        poly5.addVertex(p4);

        //poly5.setBoundaryColor(Color.red);

        sArray[4] = poly5;

        p1 = new Point(471, 408);
        p2 = new Point(471, 428);
        p3 = new Point(457, 428);
        p4 = new Point(457, 441);
        p5 = new Point(441, 441);
        p6 = new Point(441, 469);
        p7 = new Point(457, 469);
        p8 = new Point(457, 483);
        p9 = new Point(471, 483);
        p10 = new Point(471, 502);
        p11 = new Point(495, 502);
        p12 = new Point(495, 483);
        p13 = new Point(508, 483);
        p14 = new Point(508, 471);
        p15 = new Point(524, 471);
        p16 = new Point(524, 441);
        Point p17 = new Point(508, 441);
        Point p18 = new Point(508, 428);
        Point p19 = new Point(495, 428);
        Point p20 = new Point(495, 408);

        SimplePolygon poly6 = new SimplePolygon(); //Dinner table
        poly6.addVertex(p1);
        poly6.addVertex(p2);
        poly6.addVertex(p3);
        poly6.addVertex(p4);
        poly6.addVertex(p5);
        poly6.addVertex(p6);
        poly6.addVertex(p7);
        poly6.addVertex(p8);
        poly6.addVertex(p9);
        poly6.addVertex(p10);
        poly6.addVertex(p11);
        poly6.addVertex(p12);
        poly6.addVertex(p13);
        poly6.addVertex(p14);
        poly6.addVertex(p15);
        poly6.addVertex(p16);
        poly6.addVertex(p17);
        poly6.addVertex(p18);
        poly6.addVertex(p19);
        poly6.addVertex(p20);

        //poly6.setBoundaryColor(Color.red);

        sArray[5] = poly6;


        p1 = new Point(514, 578);
        p2 = new Point(514, 584);
        p3 = new Point(499, 606);
        p4 = new Point(494, 604);
        p5 = new Point(521, 639);
        p6 = new Point(520, 630);
        p7 = new Point(540, 606);
        p8 = new Point(547, 605);

        SimplePolygon poly7 = new SimplePolygon(); //Left loveseat
        poly7.addVertex(p1);
        poly7.addVertex(p2);
        poly7.addVertex(p3);
        poly7.addVertex(p4);
        poly7.addVertex(p5);
        poly7.addVertex(p6);
        poly7.addVertex(p7);
        poly7.addVertex(p8);

        //poly7.setBoundaryColor(Color.red);

        sArray[6] = poly7;


        p1 = new Point(608, 604);
        p2 = new Point(615, 605);
        p3 = new Point(634, 630);
        p4 = new Point(636, 640);
        p5 = new Point(663, 603);
        p6 = new Point(657, 605);
        p7 = new Point(639, 585);
        p8 = new Point(643, 577);

        SimplePolygon poly8 = new SimplePolygon(); //Right loveseat
        poly8.addVertex(p1);
        poly8.addVertex(p2);
        poly8.addVertex(p3);
        poly8.addVertex(p4);
        poly8.addVertex(p5);
        poly8.addVertex(p6);
        poly8.addVertex(p7);
        poly8.addVertex(p8);

        //poly8.setBoundaryColor(Color.red);

        sArray[7] = poly8;


        p1 = new Point(521, 674);
        p2 = new Point(521, 681);
        p3 = new Point(513, 681);
        p4 = new Point(513, 711);
        p5 = new Point(521, 711);
        p6 = new Point(521, 733);
        p7 = new Point(656, 733);
        p8 = new Point(656, 711);
        p9 = new Point(664, 711);
        p10 = new Point(664, 681);
        p11 = new Point(656, 681);
        p12 = new Point(656, 674);

        SimplePolygon poly9 = new SimplePolygon(); //Couch
        poly9.addVertex(p1);
        poly9.addVertex(p2);
        poly9.addVertex(p3);
        poly9.addVertex(p4);
        poly9.addVertex(p5);
        poly9.addVertex(p6);
        poly9.addVertex(p7);
        poly9.addVertex(p8);
        poly9.addVertex(p9);
        poly9.addVertex(p10);
        poly9.addVertex(p11);
        poly9.addVertex(p12);

        //poly9.setBoundaryColor(Color.red);

        sArray[8] = poly9;


        p1 = new Point(524, 293);
        p2 = new Point(578, 399);
        p3 = new Point(603, 383);
        p4 = new Point(548, 277);
        
        SimplePolygon poly10 = new SimplePolygon(); //Desser room # 2
        poly10.addVertex(p1);
        poly10.addVertex(p2);
        poly10.addVertex(p3);
        poly10.addVertex(p4);

        //poly10.setBoundaryColor(Color.red);

        sArray[9] = poly10;


        p1 = new Point(758, 299);
        p2 = new Point(663, 362);
        p3 = new Point(702, 439);
        p4 = new Point(797, 376);
        
        SimplePolygon poly11 = new SimplePolygon(); //Bed room # 2
        poly11.addVertex(p1);
        poly11.addVertex(p2);
        poly11.addVertex(p3);
        poly11.addVertex(p4);

        //poly11.setBoundaryColor(Color.red);

        sArray[10] = poly11;


        p1 = new Point(803, 387);
        p2 = new Point(708, 449);
        p3 = new Point(747, 528);
        p4 = new Point(842, 464);
        
        SimplePolygon poly12 = new SimplePolygon(); //Bed room # 3
        poly12.addVertex(p1);
        poly12.addVertex(p2);
        poly12.addVertex(p3);
        poly12.addVertex(p4);

        //poly12.setBoundaryColor(Color.red);

        sArray[11] = poly12;


        p1 = new Point(676, 592);
        p2 = new Point(731, 697);
        p3 = new Point(755, 682);
        p4 = new Point(701, 575);
        
        SimplePolygon poly13 = new SimplePolygon(); //Dresser room # 3
        poly13.addVertex(p1);
        poly13.addVertex(p2);
        poly13.addVertex(p3);
        poly13.addVertex(p4);

        //poly13.setBoundaryColor(Color.red);

        sArray[12] = poly13;


        p1 = new Point(138, 25);
        p2 = new Point(21, 254);
        p3 = new Point(379, 254);
        p4 = new Point(379, 264);
        p5 = new Point(21, 264);
        p6 = new Point(138, 493);
        p7 = new Point(216, 493);
        p8 = new Point(216, 331);
        p9 = new Point(333, 331);
        p10 = new Point(333, 340);
        p11 = new Point(225, 340);
        p12 = new Point(225, 493);
        p13 = new Point(379, 493);
        p14 = new Point(504, 734);
        p15 = new Point(737, 734);
        p16 = new Point(659, 577);
        p17 = new Point(666, 574);
        p18 = new Point(745, 728);
        p19 = new Point(862, 499);
        p20 = new Point(804, 385);
        Point p21 = new Point(625, 503);
        Point p22 = new Point(620, 497);
        Point p23 = new Point(800, 377);
        Point p24 = new Point(744, 264);
        Point p25 = new Point(509, 264);
        Point p26 = new Point(587, 419);
        Point p27 = new Point(582, 424);
        Point p28 = new Point(497, 264);
        Point p29 = new Point(459, 264);
        Point p30 = new Point(459, 254);
        Point p31 = new Point(492, 254);
        Point p32 = new Point(375, 25);



        SimplePolygon poly14 = new SimplePolygon(); //House inside border
        poly14.addVertex(p1);
        poly14.addVertex(p2);
        poly14.addVertex(p3);
        poly14.addVertex(p4);
        poly14.addVertex(p5);
        poly14.addVertex(p6);
        poly14.addVertex(p7);
        poly14.addVertex(p8);
        poly14.addVertex(p9);
        poly14.addVertex(p10);
        poly14.addVertex(p11);
        poly14.addVertex(p12);
        poly14.addVertex(p13);
        poly14.addVertex(p14);
        poly14.addVertex(p15);
        poly14.addVertex(p16);
        poly14.addVertex(p17);
        poly14.addVertex(p18);
        poly14.addVertex(p19);
        poly14.addVertex(p20);
        poly14.addVertex(p21);
        poly14.addVertex(p22);
        poly14.addVertex(p23);
        poly14.addVertex(p24);
        poly14.addVertex(p25);
        poly14.addVertex(p26);
        poly14.addVertex(p27);
        poly14.addVertex(p28);
        poly14.addVertex(p29);
        poly14.addVertex(p30);
        poly14.addVertex(p31);
        poly14.addVertex(p32);

        //poly14.setBoundaryColor(Color.red);

        sArray[13] = poly14;

        //graphing
        FrameDisplay frame = new FrameDisplay(900, 800, sArray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Vector[] angle = new Vector[8];
        Vector v0 = new Vector(0, -1);
        angle[0] = v0;
        Vector v45 = new Vector(1, -1);
        angle[1] = v45;
        Vector v90 = new Vector(1, 0);
        angle[2] = v90;
        Vector v135 = new Vector(1,1);
        angle[3] = v135;
        Vector v180 = new Vector(0, 1);
        angle[4] = v180;
        Vector v225 = new Vector(-1, 1);
        angle[5] = v225;
        Vector v270 = new Vector(-1, 0);
        angle[6] = v270;
        Vector v315 = new Vector(-1, -1);
        angle[7] = v315;

        int dir = 0;

        while (true) {
            delay(5);
            Boolean intersection = false;
            rec1.translate(angle[dir]);

            for (int i = 1; i < sArray.length; i++) {
                SimplePolygon pol1 = new SimplePolygon();
                Point r1 = rec1.getBegin();
                Point r2 = new Point(rec1.getBegin().getX(), rec1.getEnd().getY());
                Point r3 = rec1.getEnd();
                Point r4 = new Point(rec1.getEnd().getX(), rec1.getBegin().getY());
                pol1.addVertex(r1);
                pol1.addVertex(r2);
                pol1.addVertex(r3);
                pol1.addVertex(r4);
                SimplePolygon pol2 = (SimplePolygon)sArray[i];

                if (SimplePolygon.isThereAnIntersection(pol1,pol2)) {
                    intersection = true;
                    break;
               }
           }
           if (intersection) {
                rec1.translate(angle[dir].neg());
                Random rand = new Random();
                int newDir = rand.nextInt(8);
                dir = newDir;
           }

           frame.repaint();
        }
    }
}
