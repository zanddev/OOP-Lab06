package it.unibo.oop.lab.collections2;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     * Save people followed by a user organised in groups in a generic-type Mao
     */
    final Map<String, Set<U>> friends = new HashMap<>();
    /*
     * Save people followed by a user organised in groups in a generic-type Mao
     */

    /**
     * Builds a new {@link SocialNetworkUserImpl} participating in a social network.
     * 
     * @param name
     *            the user first name
     * @param surname
     *            the user last name
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application (username)
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
    }

    /**
     * Builds a new {@link SocialNetworkUserImpl} without defining the user's age.
     * 
     * @param name
     *            the user first name
     * @param surname
     *            the user last name
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        super(name, surname, user);
    }

    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        return false;
    }

    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        return null;
    }

    @Override
    public List<U> getFollowedUsers() {
        return null;
    }

}
