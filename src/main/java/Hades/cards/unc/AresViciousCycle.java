package Hades.cards.unc;

import Hades.cards.abs.abs_hades_card;
import Hades.powers.HermesSwiftStrikePower;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.doDmg;
import static Hades.util.actionShortcuts.doPow;

public class AresViciousCycle extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            AresViciousCycle.class.getSimpleName(),
            COSTS[4],
            CardType.ATTACK,
            AbstractCard.CardTarget.ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DAMAGE = 20;
    private static final int UPG_DAMAGE = 5;
    private static final int DISPLAY_MAGIC = 1;
    public AresViciousCycle() {
        super(cardInfo, false);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(DISPLAY_MAGIC);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) { doDmg(m, damage); }
    public void applyPowers(){
        super.applyPowers();
        if(!(this.costForTurn == 0)){
            int costReduction = 0;
            for(AbstractCard c: AbstractDungeon.actionManager.cardsPlayedThisTurn) {
                if (c.type == CardType.ATTACK) { costReduction += magicNumber; }
            }
            setCostForTurn(this.cost - costReduction);
        }

    }
}