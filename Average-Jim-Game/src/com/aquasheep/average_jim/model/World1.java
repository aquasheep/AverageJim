package com.aquasheep.average_jim.model;

import com.badlogic.gdx.math.Vector2;

public class World1 extends AbstractWorld 
{	
	public World1() {
		jim = new Jim(new Vector2(7, 2));
		width = 10f;
		height = 3f;
		for (int i = 0; i < 10; ++i) {
			blocks.add(new Block(new Vector2(i, 0)));
			if (i > 2)
				blocks.add(new Block(new Vector2(i, 1)));
		}
		blocks.add(new Block(new Vector2(9, 2)));
		blocks.add(new Block(new Vector2(9, 3)));
		blocks.add(new Block(new Vector2(9, 4)));
		blocks.add(new Block(new Vector2(9, 5)));
		blocks.add(new Block(new Vector2(-1, 2)));
		blocks.add(new Block(new Vector2(-1, 3)));
		blocks.add(new Block(new Vector2(-1, 4)));
		blocks.add(new Block(new Vector2(-1, 5)));
		blocks.add(new Block(new Vector2(-1, 3)));
		blocks.add(new Block(new Vector2(6, 4)));
		blocks.add(new Block(new Vector2(6, 5)));
	}
}
