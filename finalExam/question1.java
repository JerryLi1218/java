package finalExam;

import java.util.Scanner;

/*
 * 设计一个名为 Pet 的类及其名为 Cat 和 Dog 的两个子类。
 * 宠物有一个昵称。宠物还有一个定量属性，“幸福”。
 * 你可以和宠物一起玩，宠物的幸福感会增加。
 * 你可以惩罚宠物，宠物的幸福感会下降。
 * 宠物会说话，狗说“旺旺”，猫说“喵喵”。
 * 编写一个程序来测试您的类。您必须在程序中使用多态性。
 */

public class question1 {
	public static void main(String[] args) {
		
		String pet = null;
		String option = null;
		int happiness = 0;
		Scanner scanner = new Scanner(System.in);
		
		loop:while(true) {
			System.out.println("please choose your pet:Cat/Dog");
			pet = scanner.nextLine();
			switch(pet){
			case "Cat":
				Cat c = new Cat(100);
				c.speak();
				System.out.println("you have a cat now!");
				System.out.println("play or punish?");
				option = scanner.nextLine();
				switch(option) {
				case "play":
					c.bePlayed();
					break;
				case "punish":
					c.bePunished();
					break;
					default :break;
				}
				break;
			case "Dog":
				Dog d = new Dog(100);
				d.speak();
				System.out.println("you have a cat now!");
				System.out.println("play or punish?");
				option = scanner.nextLine();
				switch(option) {
				case "play":
					d.bePlayed();
					break;
				case "punish":
					d.bePunished();
					break;
					default :break;
				}
				break;
				
			}
		}

	}

}

class Pet {
	public String voice;
	public int happiness;
	
	public Pet(int happiness_) {
		happiness = happiness_;
	}
	
	void speak() {}
	
	public void bePlayed() {
		speak();
		happiness++;
		System.out.println("you play with your pet,the happiness:"+happiness+" is upup~");
	}
	
	public void bePunished() {
		speak();
		happiness--;
		System.out.println("you punish your pet,the happiness:"+happiness+" gets down -A-");
	}
}


class Cat extends Pet{
	public Cat(int happiness_) {super(happiness_);}

	void speak() {
		System.out.println("MewMew");
	}
}

class Dog extends Pet{
	public Dog(int happiness_) {super(happiness_);}

	void speak() {
		System.out.println("WangWang");
	}
}