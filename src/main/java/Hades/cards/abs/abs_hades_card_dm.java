package Hades.cards.abs;

import Hades.chr.chr_hades;
import Hades.util.CardInfo;
import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.cards.AbstractCard;

import java.util.ArrayList;

public abstract class abs_hades_card_dm extends abs_hades_card {
    private float rotationTimer = getRotationTimeNeeded();
    private int previewIndex;
    protected ArrayList<AbstractCard> cardToPreview = new ArrayList<>();
    public abs_hades_card_dm(CardInfo cardInfo, boolean upgradesDescription) { super(chr_hades.Enums.HADES_COLOUR, cardInfo.cardName, cardInfo.cardCost, cardInfo.cardType, cardInfo.cardTarget, cardInfo.cardRarity, upgradesDescription); }
    protected float getRotationTimeNeeded() {
        return 2f;
    }
    @Override
    public void update() {
        super.update();
        if (hb.hovered) {
            if (rotationTimer <= 0F) {
                rotationTimer = getRotationTimeNeeded();
                if (cardToPreview.size() == 0) {
                    cardsToPreview = null;
                } else {
                    cardsToPreview = cardToPreview.get(previewIndex);
                }
                if (previewIndex >= cardToPreview.size() - 1) {
                    previewIndex = 0;
                } else {
                    previewIndex++;
                }
            } else {
                rotationTimer -= Gdx.graphics.getDeltaTime();
            }
        }
    }
    @Override
    public void unhover() {
        super.unhover();
        cardsToPreview = null;
    }
    protected void upgradeCardToPreview() {
        for (AbstractCard q : cardToPreview) {
            q.upgrade();
        }
    }
}
