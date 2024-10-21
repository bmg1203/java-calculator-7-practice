package calculator.view;

public class Output {

	private static final String RESULT_MESSAGE = "결과 : ";
	private static final String DEFAULT_VALUE = "0";
	private static final String INPUT_PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

	public static void printResult(int result){
		System.out.println(RESULT_MESSAGE + result);
	}

	public static void printDefaultResult(){
		System.out.println(RESULT_MESSAGE + DEFAULT_VALUE);
	}

	public static void printInputPrompt(){
		System.out.println(INPUT_PROMPT_MESSAGE);
	}
}
