/* “I Travis Downie(tr638019) affirm that this program is entirely my own work and that I have 
 * neither developed my code together with any another person, nor copied any code from any other 
 * person, nor permitted my code to be copied or otherwise used by any other person, nor have I 
 * copied, modified, or otherwise used programs created by others. I acknowledge that any violation
 * of the above terms will be treated as academic dishonesty.” */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class VigènereCipher {
	
	public static void main(String[] args) {
		Input(args);
	}
	
	public static void Input(String[] args) {
		
		try {
			
			File file = new File(args[0]);
			Scanner scanner = new Scanner(file);
			String keyFile = new String();
			while(scanner.hasNext()) {
				keyFile += scanner.next();
			}
			String key = new String();
			int i, j = 0;
			for(i = 0; i < keyFile.length(); i ++) {
				if(Character.isLetter(keyFile.charAt(i)) == true) {
					key += keyFile.charAt(i);
				}
			}
			key = key.toLowerCase();
			char[] key2 = new char[key.length()];
			key2 = key.toCharArray();
			System.out.println(key2);
			File file2 = new File(args[1]);
			Scanner scanner2 = new Scanner(file2);
			ArrayList<String> list = new ArrayList<String>();
			while(scanner2.hasNext()) {
				String pTextFile = scanner2.next();
				list.add(pTextFile);
			}
			char[] charArray2 = list.toString().toCharArray();
			char[] plainText = new char[512];
			j = 0;
			for(i = 0; i < charArray2.length; i++) {
				if(Character.isLetter(charArray2[i]) == true) {
					plainText[j] = charArray2[i];
					j++;
				}
			}
			for(i = 0; i < plainText.length; i++) {
				if(Character.isLowerCase(plainText[i]) == false) {
					char letter2 = Character.toLowerCase(plainText[i]);
					plainText[i] = letter2;
				}
			}
			for(i = 0; i < plainText.length; i++) {
				if(plainText[i] == 0) {
					plainText[i] = 'x';
				}
			}
			System.out.println(" ");
			System.out.println(plainText);
			Character[] arg = new Character[key2.length];
			for(i = 0; i < key2.length; i++) {
				arg[i] = key2[i];
			}
			Character[] arg2 = new Character[plainText.length];
			for(i = 0; i < plainText.length; i++) {
				arg2[i] = plainText[i];
			}
			Encrypt(arg, arg2);
			scanner.close();
			scanner2.close();
			
		}catch(FileNotFoundException e) {
		
			System.out.println("File not found!");
		
		}
		
	}
	
	public static void Encrypt(Character key[], Character plainText[]) {
		
		int i;
		String keyString = new String();
		for(i = 0; i < key.length; i++) {
			keyString += key[i].toString();
		}
		String pTextString = new String();
		for(i = 0; i < plainText.length; i++) {
			pTextString += plainText[i].toString();
		}
		String newKey = new String();
		for(i = 0; i < pTextString.length(); i++) {
			newKey += keyString.charAt(i % keyString.length());
		}
		String cipherText = new String();
		char eLetter;
		for(i = 0; i < newKey.length(); i++) {
			char letter_Key = newKey.charAt(i);
			int num_Key = ((int)letter_Key) - 97;
			char letter_Text = pTextString.charAt(i);
			int num_Text = ((int)letter_Text) - 97;
			eLetter = (char)(((num_Text + num_Key) % 26) + 97);
			cipherText += eLetter;
		}
		System.out.println("");
		for(i = 0; i < cipherText.length(); i++) {
			System.out.print(cipherText.charAt(i));
			if((i + 1) % 80 == 0) {
				System.out.println();
			}
		}
	
	}	
	
}
