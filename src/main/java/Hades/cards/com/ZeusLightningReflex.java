package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.doDef;
import static Hades.util.actionShortcuts.doDmg;

public class ZeusLightningReflex extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            ZeusLightningReflex.class.getSimpleName(),
            COSTS[1],
            CardType.ATTACK,
            CardTarget.ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DAMAGE = 5;
    private static final int BLOCK = 5;
    private static final int UPG_COST = 0;
    public ZeusLightningReflex() {
        super(cardInfo, false);
        setDamage(DAMAGE);
        setBlock(BLOCK);
        setCostUpgrade(UPG_COST);
        this.tags.add(hadesCards.ZEUS);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doDmg(m, damage);
        doDef(this.block);
    }
}