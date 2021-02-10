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

public class AresImpendingDoom extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            AresImpendingDoom.class.getSimpleName(),
            COSTS[1],
            AbstractCard.CardType.ATTACK,
            AbstractCard.CardTarget.ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DMG = 5;
    private static final int UPG_DMG = 3;
    private static final int DOOM = 1;
    public AresImpendingDoom() {
        super(cardInfo, false);
        setDamage(DMG, UPG_DMG);
        setMagic(DOOM);
        tags.add(hadesCards.ARES);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doDmg(m, this.damage);
        doPow(m, new DoomPower(m, magicNumber));
        atb(new TriggerMarksAction(this));
    }
}