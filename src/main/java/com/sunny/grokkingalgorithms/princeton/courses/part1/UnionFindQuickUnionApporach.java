package com.sunny.grokkingalgorithms.princeton.courses.part1;

import java.util.Scanner;

/**
 * Created by sundas on 2/4/2018.
 */
public class UnionFindQuickUnionApporach {

   /*
  Goal. Design efficient data structure for union-find.
?Number of objects N can be huge.
?Number of operations M can be huge.
?Find queries and union commands may be intermixed.
Union-find data type (API)
public class UF
UF(int N)
initialize union-find data structure with
N objects (0 to N – 1)
void union(int p, int q) add connection between p and q
boolean connected(int p, int q) are p and q in the same component?
int find(int p) component identifier for p (0 to N – 1)
int count() number of components
   */

  private int[] idArray;

  public UnionFindQuickUnionApporach(int numberOfObjects) {
    idArray = new int[numberOfObjects];
    populateIdArray();
  }

  /**
   * Initial seeding
   *
   */
  private void populateIdArray(){
    /*
    Initial population the value at each index is equal to the index which is its id
    for example:
    [0,1,2,3,4,5]
     */
    for(int i = 0 ; i < idArray.length ; i++){
      idArray[i] = i;
    }
  }


  /**
   * In this implementation we basically update the root of q as root of p (traversing if necessary)
   *
   *
   * @param p
   * @param q
   */
  public void union(int p,int q){
    // parent of q is p.
    int i = findAbsoluteRoot(p);
    int j = findAbsoluteRoot(q);
    idArray[j] = i;
    printIdArray();
  }


  public int findAbsoluteRoot(int i){
    /*
    until element at index is a root of itself
     */
    while(idArray[i] != i){
      i = idArray[i];
    }
    return i;
  }


  /**
   * This is to check if there is a connection from p to q,
   *
   * @param p
   * @param q
   * @return
   */
  public boolean isConnected(int p,int q){
    boolean connected = false;
    if(p < idArray.length && q < idArray.length) {
      //if roots are equal
      if(findAbsoluteRoot(p) == findAbsoluteRoot(q)){
        connected = true;
      }
    }
    printIdArray();
    return connected;
  }

  public void printIdArray(){
    System.out.println();
    for(int i = 0 ; i < idArray.length ; i++){
      System.out.print(idArray[i] + " ");
    }
    System.out.println();
  }


  public static void main(String[] args) {
    /*
    Client driver program
    "C:\Program Files\Java\jdk1.8.0_45\bin\java" -Didea.launcher.port=7535 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 14.1.2\bin" -Dfile.encoding=windows-1252 -classpath "C:\Program Files\Java\jdk1.8.0_45\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\rt.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_45\jre\lib\ext\zipfs.jar;D:\project\B2B\HL7API\hapi-dist-2.2-all\lib\hapi-base-2.2.jar;D:\project\B2B\HL7API\hapi-dist-2.2-all\lib\hapi-examples-2.2.jar;D:\project\B2B\HL7API\hapi-dist-2.2-all\lib\hapi-hl7overhttp-2.2.jar;D:\project\B2B\HL7API\hapi-dist-2.2-all\lib\hapi-structures-v21-2.2.jar;D:\project\B2B\HL7API\hapi-dist-2.2-all\lib\hapi-structures-v22-2.2.jar;D:\project\B2B\HL7API\hapi-dist-2.2-all\lib\hapi-structures-v23-2.2.jar;D:\project\B2B\HL7API\hapi-dist-2.2-all\lib\hapi-structures-v231-2.2.jar;D:\project\B2B\HL7API\hapi-dist-2.2-all\lib\hapi-structures-v24-2.2.jar;D:\project\B2B\HL7API\hapi-dist-2.2-all\lib\hapi-structures-v25-2.2.jar;D:\project\B2B\HL7API\hapi-dist-2.2-all\lib\hapi-structures-v251-2.2.jar;D:\project\B2B\HL7API\hapi-dist-2.2-all\lib\hapi-structures-v26-2.2.jar;D:\project\B2B\HL7API\hapi-dist-2.2-all\lib\log4j-1.2.17.jar;D:\project\B2B\HL7API\hapi-dist-2.2-all\lib\slf4j-api-1.6.6.jar;D:\project\B2B\HL7API\hapi-dist-2.2-all\lib\slf4j-log4j12-1.6.6.jar;D:\project\PhoenixRising\SunnyUtil\jars\hamcrest-core-1.3-sources.jar;D:\project\PhoenixRising\SunnyUtil\jars\junit-4.12-javadoc.jar;D:\project\PhoenixRising\SunnyUtil\jars\junit-4.12-sources.jar;D:\project\PhoenixRising\SunnyUtil\jars\hamcrest-core-1.3.jar;D:\project\PhoenixRising\SunnyUtil\jars\junit-4.12.jar;D:\project\PhoenixRising\projects\PdfUtility\lib\pdfbox-app-1.8.9.jar;D:\project\B2B\Bug_21318223\Owasp\encoder-1.2-javadoc.jar;D:\project\B2B\Bug_21318223\Owasp\encoder-1.2.jar;D:\install\coherence\coherence_standalone\coherence\lib\coherence.jar;D:\project\PhoenixRising\softwareag_laptop_backup\TheCrossing\nz\ERoad\httpcomponents-client-4.4-bin.zip;D:\project\PhoenixRising\softwareag_laptop_backup\TheCrossing\nz\ERoad\json-simple-1.1.1.jar;D:\project\PhoenixRising\softwareag_laptop_backup\TheCrossing\nz\ERoad\httpcomponents-client-4.4\lib\commons-codec-1.9.jar;D:\project\PhoenixRising\softwareag_laptop_backup\TheCrossing\nz\ERoad\httpcomponents-client-4.4\lib\commons-logging-1.2.jar;D:\project\PhoenixRising\softwareag_laptop_backup\TheCrossing\nz\ERoad\httpcomponents-client-4.4\lib\fluent-hc-4.4.jar;D:\project\PhoenixRising\softwareag_laptop_backup\TheCrossing\nz\ERoad\httpcomponents-client-4.4\lib\httpclient-4.4.jar;D:\project\PhoenixRising\softwareag_laptop_backup\TheCrossing\nz\ERoad\httpcomponents-client-4.4\lib\httpclient-cache-4.4.jar;D:\project\PhoenixRising\softwareag_laptop_backup\TheCrossing\nz\ERoad\httpcomponents-client-4.4\lib\httpclient-win-4.4.jar;D:\project\PhoenixRising\softwareag_laptop_backup\TheCrossing\nz\ERoad\httpcomponents-client-4.4\lib\httpcore-4.4.jar;D:\project\PhoenixRising\softwareag_laptop_backup\TheCrossing\nz\ERoad\httpcomponents-client-4.4\lib\httpmime-4.4.jar;D:\project\PhoenixRising\softwareag_laptop_backup\TheCrossing\nz\ERoad\httpcomponents-client-4.4\lib\jna-4.1.0.jar;D:\project\PhoenixRising\softwareag_laptop_backup\TheCrossing\nz\ERoad\httpcomponents-client-4.4\lib\jna-platform-4.1.0.jar;D:\project\PhoenixRising\my git projects\time zone utility\GrokkingAlgorithms\out\production\GrokkingAlgorithms;C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 14.1.2\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain com.sunny.grokkingalgorithms.princeton.courses.part1.UnionFindQuickUnionApporach
10
4
4 3

0 1 2 4 4 5 6 7 8 9

0 1 2 4 4 5 6 7 8 9
true
3 8

0 1 2 4 4 5 6 7 4 9

0 1 2 4 4 5 6 7 4 9
true
6 5

0 1 2 4 4 6 6 7 4 9

0 1 2 4 4 6 6 7 4 9
true
9 4

0 1 2 4 9 6 6 7 4 9

0 1 2 4 9 6 6 7 4 9
true
2
1 2
Is p = 1 connected to q = 2

0 1 2 4 9 6 6 7 4 9
false
4 8
Is p = 4 connected to q = 8



Process finished with exit code -1

     */

    /*
    10
4
4 3

0 1 2 4 4 5 6 7 8 9
3 8

0 1 2 4 4 5 6 7 4 9
6 5

0 1 2 4 4 6 6 7 4 9
9 4

0 1 2 4 9 6 6 7 4 9
1
4 8
     */
    /*
    10
4
4 3


3 8


6 5


9 4


1
4 8
     */
    Scanner scanner = new Scanner(System.in);
    int numberOfObjects = scanner.nextInt();
    UnionFindQuickUnionApporach uf = new UnionFindQuickUnionApporach(numberOfObjects);
    int numberOfUnionOperations = scanner.nextInt();
    for(int i = 0 ; i < numberOfUnionOperations ; i++){
      int p = scanner.nextInt();
      int q = scanner.nextInt();
      uf.union(p,q);
      //System.out.println(uf.isConnected(p,q));
    }
    int numberOfFindOperations = scanner.nextInt();
    for(int i = 0 ; i < numberOfFindOperations ; i++){
      int p = scanner.nextInt();
      int q = scanner.nextInt();
      System.out.println("Is p = " + p + " connected to q = " + q);
      System.out.println(uf.isConnected(p,q));
    }
  }


}
