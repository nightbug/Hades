package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.atb;
import static Hades.util.actionShortcuts.doDmg;

public class ZeusDoubleStrike extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            ZeusDoubleStrike.class.getSimpleName(),
            COSTS[2],
            CardType.ATTACK,
            CardTarget.ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DAMAGE = 12;
    private static final int UPG_DAMAGE = 3;
    private static final int HITS = 2;
    public ZeusDoubleStrike() {
        super(cardInfo, false);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(HITS);
        this.tags.add(hadesCards.ZEUS);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for(int i = 0; i < magicNumber; i+= 1){ atb(new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.NONE)); }
    }
}
