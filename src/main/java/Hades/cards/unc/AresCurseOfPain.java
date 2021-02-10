package Hades.cards.unc;

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

public class AresCurseOfPain extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            AresCurseOfPain.class.getSimpleName(),
            COSTS[2],
            AbstractCard.CardType.SKILL,
            CardTarget.ALL_ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DOOM = 2;
    private static final int UPG_DOOM = 3;
    public AresCurseOfPain() {
        super(cardInfo, false);
        setMagic(DOOM, UPG_DOOM);
        tags.add(hadesCards.ARES);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for(AbstractMonster mo: getAliveMonsters()){ doPow(mo, new DoomPower(mo, magicNumber)); }
        atb(new TriggerMarksAction(this));
    }
}
