/* @java.file.header */

/*  _________        _____ __________________        _____
 *  __  ____/___________(_)______  /__  ____/______ ____(_)_______
 *  _  / __  __  ___/__  / _  __  / _  / __  _  __ `/__  / __  __ \
 *  / /_/ /  _  /    _  /  / /_/ /  / /_/ /  / /_/ / _  /  _  / / /
 *  \____/   /_/     /_/   \_,__/   \____/   \__,_/  /_/   /_/ /_/
 */

package org.gridgain.grid.kernal.processors.query.h2.sql;

import org.jetbrains.annotations.*;

import java.util.*;

/**
 * Abstract SQL element.
 */
public abstract class GridSqlElement implements Cloneable {
    /** */
    protected List<GridSqlElement> children = new ArrayList<>();

    /** {@inheritDoc} */
    public abstract String getSQL();

    /**
     * @return Children.
     */
    public List<GridSqlElement> children() {
        return children;
    }

    /**
     * @param expr Expr.
     */
    public void addChild(GridSqlElement expr) {
        assert expr != null;

        children.add(expr);
    }

    /**
     *
     */
    @NotNull public GridSqlElement child() {
        return children.get(0);
    }

    /**
     *
     */
    @NotNull public GridSqlElement child(int idx) {
        return children.get(idx);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("CloneCallsConstructors")
    @Override protected GridSqlElement clone() throws CloneNotSupportedException {
        try {
            GridSqlElement res = (GridSqlElement)super.clone();

            res.children = new ArrayList<>(children);

            return res;
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
