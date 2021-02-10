package Hades.cards.bas;

import Hades.cards.abs.abs_hades_card;
import Hades.powers.HermesSwiftStrikePower;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.doDmg;
import static Hades.util.actionShortcuts.doPow;

public class HermesSwiftStrike extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            HermesSwiftStrike.class.getSimpleName(),
            COSTS[1],
            CardType.SKILL,
            AbstractCard.CardTarget.ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int POWER_AMOUNT = 1;
    private static final int UPG_COST = 0;
    public HermesSwiftStrike() {
        super(cardInfo, false);
        setMagic(POWER_AMOUNT);
        setCostUpgrade(UPG_COST);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) { doPow(p, new HermesSwiftStrikePower(magicNumber)); }
}