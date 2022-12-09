package controllers.gameStates;

import UI.encounter_screens.MerchantEncounterView;
import UI.presenters.statePresenters.EncounterStatePresenter;
import UI.presenters.statePresenters.MerchantStatePresenter;
import UI.presenters.statePresenters.StatePresenter;
import controllers.MerchantController;
import entities.character.Merchant;
import entities.character.Player;
import settings.Initializer;
import useCases.KeyEventHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MerchantState implements State {
    StatePresenter presenter;
    Player player;
    private Merchant merchant;
    private MerchantController merchantController;
    public MerchantState(CrawlingState crawlingState){
        // TODO: get player from CrawlingState and merchant passed from collision
        super();
        this.player = crawlingState.getPlayer();
        this.presenter = new EncounterStatePresenter();
        this.merchantController = new MerchantController(player, merchant);
    }
    public MerchantState(){
        this.merchant = Initializer.getMerchant();
        this.presenter = new MerchantStatePresenter();
    }
    public void loop() {


    }

    public void keyPressEvents(int code) {

    }


    public void keyReleasedEvents(int code) {

    }

    public void clickEvents(int code) {
        KeyEventHandler.handleMerchantStateEvents(code, merchantController);
    }


    @Override
    public StatePresenter getPresenter() {
        return presenter;
    }
}
