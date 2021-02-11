package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.atb;
import static Hades.util.actionShortcuts.doDmg;

public class ZeusLightningStrike extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            ZeusLightningStrike.class.getSimpleName(),
            COSTS[0],
            CardType.ATTACK,
            CardTarget.ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DAMAGE = 4;
    private static final int UPG_DAMAGE = 2;
    private static final int SHUFFLE_AMOUNT = 1;
    public ZeusLightningStrike() {
        super(cardInfo, false);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(SHUFFLE_AMOUNT);
        this.tags.add(hadesCards.ZEUS);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doDmg(m, damage);
        atb(new MakeTempCardInDrawPileAction(this.makeStatEquivalentCopy(), magicNumber, true, true));
    }
}