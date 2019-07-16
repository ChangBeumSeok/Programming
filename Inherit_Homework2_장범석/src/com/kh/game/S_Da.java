package com.kh.game;

import java.util.Scanner;

import com.kh.model.vo.Dealer;
import com.kh.model.vo.Luckyman;
import com.kh.model.vo.Person;
import com.kh.model.vo.Richman;

public class S_Da {
	private String card[] = {"1월(광)", "1월", "2월(고도리)", "2월(홍단)", "3월(광)", "3월(홍단)", "4월(열끗)", "4월(초단)",
			"5월(??)", "5월(초단)", "6월(나비)", "6월(청단)", "7월(열끗)", "7월(초단)", "8월(광)", "8월(고도리)", "9월(열끗)", "9월(청단)"
			, "10월(사슴)", "10월(청단)"};
	
	Scanner sc = new Scanner(System.in);

	Dealer deal = new Dealer();
	private String result;
	public void play(Person player){
		String dealer_card[] = new String[3];
		String player_card[] = new String[3];
		boolean check[] = new boolean[20];
		int del_result = 0;
		int play_result = 0;
		
		System.out.print("판돈 : 1. 10000 2. 100000 3. 1000000 >>>");
		int num = sc.nextInt();
		sc.nextLine();
		int money = 0;
		if(num == 1){
			money = 10000;
		}else if(num == 2){
			money = 100000;
		}else if(num == 3){
			money = 1000000;
		}else{
			System.out.println("잘못 입력하셨습니다. 초기화면으로 갑니다.");
			return;
		}
		while(true){
			for (int i = 0; i < 2; i++) {
				int randNum = (int)(Math.random() * 14);
				if(check[randNum] == true){
					i--;
				}else{
					dealer_card[i] = card[randNum];
					check[randNum] = true;
				}
			}
			del_result = myCard(dealer_card[0], dealer_card[1]);
			if(del_result == -1){
				continue;
			}
			dealer_card[2] = result;
			break;
		} // 딜러 카드 주기
		while(true){
			for(int i = 0; i < 2; i++){
				int randNum = (int)(Math.random() * 14);
				if(check[randNum] == true){
					i--;
				}else{
					player_card[i] = card[randNum];
					check[randNum] = true;
				}
			}
			play_result = myCard(player_card[0], player_card[1]);
			if(play_result == -1){
				continue;
			}
			player_card[2] = result;
			break;
		} // 플레이어 카드 주기
		System.out.println("나의 패는 " + player_card[0] + ", " + player_card[1] + " 따라서 " + player_card[2] + "입니다.");
		System.out.print("계속하시겠습니까? ");
		String doplay = sc.nextLine();
		if(doplay.toUpperCase().equals("Y")){
			while(doplay.toUpperCase().equals("Y")){
				System.out.print("배팅 금액 : 1. 10000 2. 100000 3. 1000000 >>>");
				num = sc.nextInt();
				sc.nextLine();
				if(num == 1){
					money += 10000;
				}else if(num == 2){
					money += 100000;
				}else if(num == 3){
					money += 1000000;
				}else{
					System.out.println("잘못 입력하셨습니다. 다시누르세요.");
				}
				System.out.print("계속 배팅하시겠습니까? ");
				doplay = sc.nextLine();
			}		
		}
		
		//---------------------------결과---------------------------------
		if(play_result > del_result){
			if(player.getClass() == Richman.class){
				player.skill(money);
			}
			System.out.println("상대의 패는" + dealer_card[0] + ", " + dealer_card[1] + "따라서 " + dealer_card[2]);
			System.out.println("승리!!");
			player.setWin(player.getWin()+1);
		}else if(play_result < del_result){
			if(player.getClass() == Luckyman.class){
				player.skill(money);
			}else{
				player.setMoney(player.getMoney() - money);
			}
			System.out.println("상대의 패는" + dealer_card[0] + ", " + dealer_card[1] + "따라서 " + dealer_card[2]);
			System.out.println("패배....");
			player.setLose(player.getLose()-1);
		}else{
			System.out.println("상대의 패는" + dealer_card[0] + ", " + dealer_card[1] + "따라서 " + dealer_card[2]);
			System.out.println("비겼습니다.");
		}
		System.out.println(player.toString());
	}
	
	// ------------------------------- 족보 -------------------------------------------
	public int myCard(String a, String b){
		if(a.equals("3월(광)") && b.equals("8월(광)")){
			result = "38광떙";
			return 100; // 38광떙
		}else if((a.equals("1월(광)") && b.equals("3월(광)")) || (a.equals("1월(광)") && b.equals("8월(광)")) || 
				(b.equals("1월(광)") && a.equals("3월(광)")) || (b.equals("1월(광)") && a.equals("8월(광)")) ){
			if((a.equals("1월(광)") && b.equals("3월(광)")) || (b.equals("1월(광)") && a.equals("3월(광)"))){
				result = "13광땡";
			}else{
				result = "18광떙";
			}
			return 95;  // 13 && 18 광떙
		}else if(a.equals("10월(사슴") && b.equals("10월(청단)") || b.equals("10월(사슴") && a.equals("10월(청단)")){
			result = "장땡";
			return 90;  // 장떙
		}else if(a.equals("9월(열끗)") && b.equals("9월(청단)") || b.equals("9월(열끗)") && a.equals("9월(청단)")){
			result = "구땡";
			return 85;  // 구떙
		}else if(a.equals("8월(고도리)") && b.equals("8월(광)") || b.equals("8월(고도리)") && a.equals("8월(광)")){
			result = "팔땡";
			return 80;  // 팔땡
		}else if(a.equals("7월(열끗)") && b.equals("7월(초단)") || b.equals("7월(열끗)") && a.equals("7월(초단)")){
			result = "칠땡";
			return 75;  // 칠떙
		}else if(a.equals("6월(나비)") && b.equals("6월(청단)") || b.equals("6월(나비)") && a.equals("6월(청단)")){
			result = "육땡";
			return 70;  // 육떙
		}else if(a.equals("5월(??)") && b.equals("5월(초단)") || b.equals("5월(??)") && a.equals("5월(초단)")){ 
			result = "오땡";
			return 65;  // 오땡
		}else if(a.equals("4월(열끗)") && b.equals("4월(초단)") || b.equals("4월(열끗)") && a.equals("4월(초단)")){
			result = "사땡";
			return 60;  // 사땡
		}else if(a.equals("3월(광)") && b.equals("3월(홍단)") || b.equals("3월(광)") && a.equals("3월(홍단)")){
			result = "삼땡";
			return 55;  // 삼땡
		}else if(a.equals("2월(고도리)") && b.equals("2월(홍단)") || b.equals("2월(고도리)") && a.equals("2월(홍단)")){
			result = "이땡";
			return 50;  // 이땡
		}else if(a.equals("1월(광)") && b.equals("1월") || b.equals("1월(광)") && a.equals("1월")){
			result = "삥땡";
			return 45;  // 삥떙
		}else if((a.equals("1월(광)") && b.equals("2월(고도리)")) || (a.equals("1월(광)") && b.equals("2월(홍단)")) ||
				(a.equals("1월") && b.equals("2월(고도리)")) || (a.equals("1월") && b.equals("2월(홍단)"))){
			result = "알리";
			return 40; //알리
		}else if((a.equals("1월(광)") && b.equals("4월(열끗)")) || (a.equals("1월(광)") && b.equals("4월(초단)")) ||
				(a.equals("1월") && b.equals("4월(열끗)")) || (a.equals("1월") && b.equals("4월(초단)"))){
			result = "독사";
			return 35; // 독사
		}else if((a.equals("1월(광)") && b.equals("9월(열끗)")) || (a.equals("1월(광)") && b.equals("9월(청단)")) ||
				(a.equals("1월") && b.equals("9월(열끗)")) || (a.equals("1월") && b.equals("9월(청단)"))){
			result = "구삥";
			return 30;
		}else if((a.equals("1월(광)") && b.equals("10월(사슴)")) || (a.equals("1월(광)") && b.equals("10월(청단)")) ||
				(a.equals("1월") && b.equals("10월(사슴)")) || (a.equals("1월") && b.equals("10월(청단)"))){
			result = "장삥";
			return 25;
		}else if((a.equals("4월(광)") && b.equals("10월(사슴)")) || (a.equals("4월(광)") && b.equals("10월(청단)")) ||
				(a.equals("4월(초단)") && b.equals("10월(사슴)")) || (a.equals("4월(초단)") && b.equals("10월(청단)"))){
			result = "장사";
			return 20;
		}else if((a.equals("4월(광)") && b.equals("6월(나비)")) || (a.equals("4월(광)") && b.equals("6월(청단)")) ||
				(a.equals("4월(초단)") && b.equals("6월(나비)")) || (a.equals("4월(초단)") && b.equals("6월(청단)"))){
			result = "세륙";
			return 15;
		}else if((a.equals("1월(광)") && b.equals("2월(고도리)")) || (a.equals("1월(광)") && b.equals("2월(홍단)")) ||
				(a.equals("1월") && b.equals("2월(고도리)")) || (a.equals("1월") && b.equals("2월(홍단)"))){
			result = "갑오";
			return 10;
		}
		else{
			int sum = 0;
			if(a.equals("1월(광)") || a.equals("1월")){
			 	sum += 1;
			}else if(a.equals("2월(고도리)") || a.equals("2월(홍단)")){
				sum += 2;
			}else if(a.equals("3월(광)") || a.equals("3월(홍단)")){
				sum += 3;
			}else if(a.equals("4월(열끗)") || a.equals("4월(초단)")){
				sum += 4;
			}else if(a.equals("5월(??)") || a.equals("5월(초단)")){
				sum += 5;
			}else if(a.equals("6월(나비)") || a.equals("6월(청단)")){
				sum += 6;
			}else if(a.equals("7월(열끗)") || a.equals("7월(초단)")){
				sum += 7;
			}else if(a.equals("8월(광)") || a.equals("8월(고도리")){
				sum += 8;
			}else if(a.equals("9월(열끗)") || a.equals("9월(청단)")){
				sum += 9;
			}else if(a.equals("10월(사슴)") || a.equals("10월(청단)")){
				sum += 10;
			}
			if(b.equals("1월(광)") || b.equals("1월")){
			 	sum += 1;
			}else if(b.equals("2월(고도리)") || b.equals("2월(홍단)")){
				sum += 2;
			}else if(b.equals("3월(광)") || b.equals("3월(홍단)")){
				sum += 3;
			}else if(b.equals("4월(열끗)") || b.equals("4월(초단)")){
				sum += 4;
			}else if(b.equals("5월(??)") || b.equals("5월(초단)")){
				sum += 5;
			}else if(b.equals("6월(나비)") || b.equals("6월(청단)")){
				sum += 6;
			}else if(b.equals("7월(열끗)") || b.equals("7월(초단)")){
				sum += 7;
			}else if(b.equals("8월(광)") || b.equals("8월(고도리")){
				sum += 8;
			}else if(b.equals("9월(열끗)") || b.equals("9월(청단)")){
				sum += 9;
			}else if(b.equals("10월(사슴)") || b.equals("10월(청단)")){
				sum += 10;
			}
			if(sum >= 10){
				sum -= 10;
			}
			switch(sum){
			case 0:
				result = "망통";
				break;
			case 1:
				result = "한끗";
				break;
			case 2:
				result = "두끗";
				break;
			case 3:
				result = "세끗";
				break;
			case 4:
				result = "네끗";
				break;
			case 5:
				result = "다섯끗";
				break;
			case 6:
				result = "여섯끗";
				break;
			case 7:
				result = "일곱끗";
				break;
			case 8:
				result = "여덟끗";
				break;
			case 9:
				result = "갑오";
				return 10;
			}
			return sum;
		}
	}
}
