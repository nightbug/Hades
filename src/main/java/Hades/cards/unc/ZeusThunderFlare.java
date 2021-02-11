package Hades.cards.unc;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ThornsPower;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.*;

public class ZeusThunderFlare extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            ZeusThunderFlare.class.getSimpleName(),
            COSTS[1],
            AbstractCard.CardType.SKILL,
            AbstractCard.CardTarget.SELF
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int UPG_COST = 0;
    public ZeusThunderFlare() {
        super(cardInfo, false);
        setCostUpgrade(UPG_COST);
        this.tags.add(hadesCards.ZEUS);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new AbstractGameAction() {
            @Override
            public void update() {
                if(p.drawPile.isEmpty()){ this.isDone = true; }
                else { att(new NewQueueCardAction(p.drawPile.getTopCard(), true, true, true)); }
                this.isDone = true;
            }
        });
    }
}