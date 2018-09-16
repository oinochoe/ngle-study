package junksuck.java.headfirst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(
            new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException : " + e);
        }
        return inputLine.toLowerCase();
    }
    public ArrayList<String> placeDotCom(int comSize){
        ArrayList<String> alphaCells = new ArrayList<String>(); // 'f6'과 같은 좌표가 들어감
        String temp = null;                                     // 나중에 연결하기 위한 임시 String 배열
        String[] alphacoords = new String[comSize];             // 현재 후보 좌표
        int[] coords = new int[comSize];                        // 현재 후보 좌표
        int attempts = 0;                                       // 시도를 세기 위한 카운터
        boolean success = false;                                // 적당한 위치를 찾았는지 표시하기 위한 플래그
        int location;                                           // 현재 시작 위치

        comCount++;                                             // n번째 닷컴
        int incr = 1;                                           // 수평방향으로 증가시킬 값 설정
        if( (comCount % 2) == 1){                               // 홀수번째 닷컴인 경우(수직으로 배치)
            incr = gridLength;                                  // 수직방향으로 증가시킬 값 설정
        }

        while(!success & attempts++ < 200) {                    // 주 검색 순환문(32)
            location = (int)(Math.random() * gridSize);         // 임의의 시작위치 구함
            // System.out.println("try" + location);
            int x = 0;                                          // 위치시킬 닷컴의 n번째 위치
            success = true;                                     // 성공할 것으로 가정함
            while(success && x < comSize) {                     // 닷컴이 들어갈 자리가 비었는지 확인
                if(grid[location] == 0) {                       // 아직 사용하지 않았으면
                    coords[x++] = location;                     // 위치 저장
                    location += incr;                           // 다음칸 확인
                    if(location >= gridSize){                   // 경계를 벗어난 경우
                        success = false;                        // 실패
                    }
                    if(x > 0 && (location % gridLength == 0) ) {// 경계를 벗어난 경우(오른쪽)
                        success = false;                        // 실패
                    }
                }
                else{
                    System.out.println("used" + location);      // 이미 사용중인 경우
                    success = false;                            // 실패
                }
            }//end of inner while loop
        }//end of outer while loop

        int x = 0;                                              // 위치를 알파벳 좌표로 바꿈
        int row = 0;
        int column = 0;
        // System.out.println("\n");
        while(x < comSize) {
            grid[coords[x]] = 1;                                // 기본 그리드 좌표를 '사용 중'으로 표시
            row = (int)(coords[x] / gridLength);                // 행 값을 구함
            column = coords[x] % gridLength;                    // 열 값을 구함
            temp = String.valueOf(alphabet.charAt(column));     // 숫자된 된 열을 알파벳으로 변환

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
System.out.println(" coord " + x +" = "+ alphaCells.get(x-1));  // 컨닝 코드
        }
//System.out.println("/n");
        return alphaCells;
    }// end of method placeDotCom(int comSize)

}
