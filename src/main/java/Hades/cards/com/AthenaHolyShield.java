package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.doDef;
import static Hades.util.actionShortcuts.doDmg;

public class AthenaHolyShield extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            AthenaHolyShield.class.getSimpleName(),
            COSTS[3],
            AbstractCard.CardType.SKILL,
            AbstractCard.CardTarget.SELF
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DAMAGE = 15;
    private static final int BLOCK = 12;
    private static final int UPG_COST = 2;
    public AthenaHolyShield() {
        super(cardInfo, false);
        setDamage(DAMAGE);
        setBlock(BLOCK);
        setCostUpgrade(UPG_COST);
        this.tags.add(hadesCards.ATHENA);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doDmg(m, damage);
        doDef(this.block);
    }
}
