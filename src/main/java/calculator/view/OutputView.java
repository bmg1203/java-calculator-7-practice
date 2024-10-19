package calculator.view;

import calculator.dto.SumDto;
import calculator.view.message.OutputViewMessage;

public class OutputView {
	public static void printInformationMessage() {
		printMessage(OutputViewMessage.INFORMATION_MESSAGE);
	}

	private static <T> void printInlineMessage(T message){
		System.out.print(message);
	}

	private static <T> void printMessage(T message){
		System.out.println(message);
	}

	public static void printResultMessage(SumDto sumDto) {
		printInlineMessage(OutputViewMessage.RESULT_MESSAGE);
		printMessage(sumDto.sum());
	}
}
