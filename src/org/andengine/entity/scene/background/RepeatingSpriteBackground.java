package org.andengine.entity.scene.background;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * 通过Asset中的资源创建背景类
 * 
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 15:11:10 - 19.07.2010
 */
public class RepeatingSpriteBackground extends SpriteBackground {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private BitmapTextureAtlas mBitmapTextureAtlas;
	private final float mScale;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * @param pCameraWidth 宽
	 * @param pCameraHeight 高
	 * @param pTextureManager TextureManager,通常用getTextureManager()可以获取
	 * @param pBitmapTextureAtlasSource needs to be a power of two as otherwise the <code>repeating</code> feature doesn't work.(可用AssetBitmapTextureAtlasSource.create()生成)
	 * @param pVertexBufferObjectManager 通常用getVertexBufferObjectManager()可以获取
	 */
	public RepeatingSpriteBackground(final float pCameraWidth, final float pCameraHeight, final TextureManager pTextureManager, final IBitmapTextureAtlasSource pBitmapTextureAtlasSource, final VertexBufferObjectManager pVertexBufferObjectManager) throws IllegalArgumentException {
		this(pCameraWidth, pCameraHeight, pTextureManager, pBitmapTextureAtlasSource, 1, pVertexBufferObjectManager);
	}

	/**
	 * 
	 * @param pCameraWidth 宽
	 * @param pCameraHeight 高
	 * @param pTextureManager TextureManager,通常用getTextureManager()
	 * @param pBitmapTextureAtlasSource needs to be a power of two as otherwise the <code>repeating</code> feature doesn't work.(可用AssetBitmapTextureAtlasSource.create()生成)
	 * @param pScale 缩放比例,1为正常
	 * @param pVertexBufferObjectManager 通常用getVertexBufferObjectManager()可以获取
	 * 
	 * @throws IllegalArgumentException
	 */
	public RepeatingSpriteBackground(final float pCameraWidth, final float pCameraHeight, final TextureManager pTextureManager, final IBitmapTextureAtlasSource pBitmapTextureAtlasSource, final float pScale, final VertexBufferObjectManager pVertexBufferObjectManager) throws IllegalArgumentException {
		super(null);

		this.mScale = pScale;
		this.mEntity = this.loadSprite(pCameraWidth, pCameraHeight, pTextureManager, pBitmapTextureAtlasSource, pVertexBufferObjectManager);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public BitmapTextureAtlas getBitmapTextureAtlas() {
		return this.mBitmapTextureAtlas;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * 生成一个可以缩放的Sprite
	 * 
	 * @param pCameraWidth 宽
	 * @param pCameraHeight 高
	 * @param pTextureManager TextureManager
	 * @param pBitmapTextureAtlasSource
	 * @param pVertexBufferObjectManager
	 * @return
	 * @throws IllegalArgumentException
	 */
	private Sprite loadSprite(final float pCameraWidth, final float pCameraHeight, final TextureManager pTextureManager, final IBitmapTextureAtlasSource pBitmapTextureAtlasSource, final VertexBufferObjectManager pVertexBufferObjectManager) throws IllegalArgumentException {
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(pTextureManager, pBitmapTextureAtlasSource.getTextureWidth(), pBitmapTextureAtlasSource.getTextureHeight(), BitmapTextureFormat.RGBA_8888, TextureOptions.REPEATING_NEAREST);
		final ITextureRegion textureRegion = BitmapTextureAtlasTextureRegionFactory.createFromSource(this.mBitmapTextureAtlas, pBitmapTextureAtlasSource, 0, 0);

		final int width = Math.round(pCameraWidth / this.mScale);
		final int height = Math.round(pCameraHeight / this.mScale);

		textureRegion.setTextureWidth(width);
		textureRegion.setTextureHeight(height);

		this.mBitmapTextureAtlas.load();

		final Sprite sprite = new Sprite(0, 0, width, height, textureRegion, pVertexBufferObjectManager);
		sprite.setScaleCenter(0, 0);
		sprite.setScale(this.mScale);
		return sprite;
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
