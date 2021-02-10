package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.powers.DoomPower;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.actions.watcher.TriggerMarksAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.*;

public class AresCurseOfAgony extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            AresCurseOfAgony.class.getSimpleName(),
            COSTS[1],
            AbstractCard.CardType.SKILL,
            CardTarget.ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DOOM = 8;
    private static final int UPG_DOOM = 3;
    public AresCurseOfAgony() {
        super(cardInfo, false);
        setMagic(DOOM, UPG_DOOM);
        tags.add(hadesCards.ARES);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doPow(m, new DoomPower(m, magicNumber));
        atb(new TriggerMarksAction(this));
    }
}
