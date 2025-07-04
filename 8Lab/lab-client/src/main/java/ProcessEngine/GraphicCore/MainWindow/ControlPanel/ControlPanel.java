package ProcessEngine.GraphicCore.MainWindow.ControlPanel;

import ProcessEngine.DataCore.DataRun;
import ProcessEngine.GraphicCore.GraphicRun;
import ProcessEngine.GraphicCore.MainWindow.AdditionalWindows.CountByTypePopUpWindow.CountByTypePopUpWindow;
import ProcessEngine.GraphicCore.MainWindow.AdditionalWindows.Factories.BoxFactory;
import ProcessEngine.GraphicCore.MainWindow.AdditionalWindows.Factories.ButtonFactory;
import ProcessEngine.GraphicCore.MainWindow.AdditionalWindows.InsertPopUpWindow.InsertPopUpWindow;
import ProcessEngine.GraphicCore.MainWindow.AdditionalWindows.RemoveGrPopUpWindow.RemoveGrPopUpWindow;
import ProcessEngine.GraphicCore.MainWindow.AdditionalWindows.RemoveKeyPopUpWindow.RemoveKeyPopUpWindow;
import ProcessEngine.GraphicCore.MainWindow.AdditionalWindows.RemoveLowKeyPopUpWindow.RemoveLowKeyPopUpWindow;
import ProcessEngine.GraphicCore.MainWindow.AdditionalWindows.RemoveLowPopUpWindow.RemoveLowPopUpWindow;
import ProcessEngine.GraphicCore.MainWindow.AdditionalWindows.SumOfPricePopUpWindow.SumOfPricePopUpWindow;
import ProcessEngine.GraphicCore.MainWindow.AdditionalWindows.UpdatePopUpWindow.UpdatePopUpWindow;
import ProcessEngine.GraphicCore.MainWindow.DataSheet.DataSheet;
import ProcessEngine.GraphicCore.MainWindow.DataSheet.SorteByColumn.ColumnSortFlag;
import ProcessEngine.ProcessCore.networkModule.NetworkManager;
import network.Request;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Arrays;

public class ControlPanel {

    protected DataRun dataRun;
    protected NetworkManager networkManager;
    protected String login;
    protected String password;

    public ControlPanel(DataRun dataRun, NetworkManager networkManager, String login, String password) {
        this.dataRun = dataRun;
        this.networkManager = networkManager;
        this.login = login;
        this.password = password;
    }

    public VBox getCommands() {
        VBox commands = new VBox();
        commands.setAlignment(Pos.CENTER_LEFT);
        commands.setSpacing(17);
        commands.setPadding(new Insets(30, 30, 30, 30));

        Button update = ButtonFactory.getCommandButton(GraphicRun.localizator.getString("update"));
        update.setOnAction(event -> {
            Stage stage = UpdatePopUpWindow.updateWindow(networkManager, login, password, dataRun);
            stage.show();
        });

        Button insert = ButtonFactory.getCommandButton(GraphicRun.localizator.getString("insert"));
        insert.setOnAction(event -> {
            Stage stage = InsertPopUpWindow.insertWindow(networkManager, login, password);
            stage.show();
        });

        HBox first = BoxFactory.getBoxWithNodes(update, insert);

        Button removeGreater = ButtonFactory.getCommandButton(GraphicRun.localizator.getString("remove") + GraphicRun.localizator.getString("greater"));
        removeGreater.setOnAction(event -> {
            Stage stage = RemoveGrPopUpWindow.removeGreaterWindow(networkManager, login, password);

            stage.show();
        });

        Button removeLower = ButtonFactory.getCommandButton(GraphicRun.localizator.getString("remove") + GraphicRun.localizator.getString("lower"));
        removeLower.setOnAction(event -> {
            Stage stage = RemoveLowPopUpWindow.removeLowerWindow(networkManager, login, password);

            stage.show();
        });

        HBox second = BoxFactory.getBoxWithNodes(removeGreater, removeLower);
        second.setPadding(new Insets(17, 0, 0, 0));

        Button removeLowerKey = ButtonFactory.getCommandButton(GraphicRun.localizator.getString("remove") + GraphicRun.localizator.getString("lower") + " " + GraphicRun.localizator.getString("by key"));
        removeLowerKey.setOnAction(event -> {
            Stage stage = RemoveLowKeyPopUpWindow.removeLowerKeyWindow(networkManager, login, password);

            stage.show();
        });

        Button removeKey = ButtonFactory.getCommandButton(GraphicRun.localizator.getString("remove") + GraphicRun.localizator.getString("by key"));
        removeKey.setOnAction(event -> {
            Stage stage = RemoveKeyPopUpWindow.removeKeyWindow(networkManager, login, password);

            stage.show();
        });

        HBox third = BoxFactory.getBoxWithNodes(removeLowerKey, removeKey);
        third.setPadding(new Insets(0, 0, 17, 0));

        Button sum = ButtonFactory.getCommandButton(GraphicRun.localizator.getString("sum"));
        sum.setOnAction(event -> {
            Stage stage = SumOfPricePopUpWindow.sumWindow(dataRun);

            stage.show();
        });

        Button count = ButtonFactory.getCommandButton(GraphicRun.localizator.getString("count by type"));
        count.setOnAction(event -> {
            Stage stage = CountByTypePopUpWindow.countWindow(dataRun);

            stage.show();
        });

        HBox fourth = BoxFactory.getBoxWithNodes(sum, count);

        Button printAscending = ButtonFactory.getCommandButton(GraphicRun.localizator.getString("print ascending")); // Написать setOnAction
        printAscending.setOnAction(event -> {
            ColumnSortFlag.setColumnSortFlag(
                    "priceFlagSort",
                    DataSheet.headerKeyButton,
                    DataSheet.headerIdButton,
                    DataSheet.headerNameButton,
                    DataSheet.headerXButton,
                    DataSheet.headerYButton,
                    DataSheet.headerCreationDateButton,
                    DataSheet.headerPriceButton,
                    DataSheet.headerTypeButton,
                    DataSheet.headerBirthdayButton,
                    DataSheet.headerEyeButton,
                    DataSheet.headerHairButton,
                    DataSheet.headerCountryButton
            );
        });
        Button clear = ButtonFactory.getCommandButton(GraphicRun.localizator.getString("clear"));
        HBox fifth = BoxFactory.getBoxWithNodes(printAscending, clear);
        clear.setOnAction(event -> {
            Request request = new Request();
            request.setUser(login);
            request.setPassword(Arrays.toString(password
                    .chars()
                    .mapToObj(c -> String.valueOf((char) c))
                    .toArray(String[]::new))
            );
            request.setCommandName("clear");
            request.setTokens("clear");

            networkManager.sendAndReceive(request);
        });

        commands.getChildren().addAll(first, second, third, fourth, fifth);

        return commands;
    }

}
