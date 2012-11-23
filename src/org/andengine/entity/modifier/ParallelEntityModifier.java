package org.andengine.entity.modifier;

import org.andengine.entity.IEntity;
import org.andengine.util.modifier.ParallelModifier;

/**
 * 多个动作同时执行<br><br>
 * 
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 12:40:31 - 03.09.2010
 */
public class ParallelEntityModifier extends ParallelModifier<IEntity> implements IEntityModifier {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * 多个动作同时执行
	 * @param pEntityModifiers 多个需要同时执行的动作
	 * @throws IllegalArgumentException
	 */
	public ParallelEntityModifier(final IEntityModifier... pEntityModifiers) throws IllegalArgumentException {
		super(pEntityModifiers);
	}

	/**
	 * 多个动作同时执行
	 * @param pEntityModifierListener
	 * @param pEntityModifiers
	 * @throws IllegalArgumentException
	 */
	public ParallelEntityModifier(final IEntityModifierListener pEntityModifierListener, final IEntityModifier... pEntityModifiers) throws IllegalArgumentException {
		super(pEntityModifierListener, pEntityModifiers);
	}

	/**
	 * 多个动作同时执行
	 * @param pParallelShapeModifier
	 * @throws DeepCopyNotSupportedException
	 */
	protected ParallelEntityModifier(final ParallelEntityModifier pParallelShapeModifier) throws DeepCopyNotSupportedException {
		super(pParallelShapeModifier);
	}

	@Override
	public ParallelEntityModifier deepCopy() throws DeepCopyNotSupportedException {
		return new ParallelEntityModifier(this);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
